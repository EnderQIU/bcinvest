package cn.enderqiu.bcinvestrebuild.util;

import cn.ssyram.blockchain.interfaces.CreditChain;
import com.generator.tables.Company;
import com.generator.tables.Creditupdatetask;
import com.generator.tables.records.CompanyRecord;
import com.generator.tables.records.CreditupdatetaskRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditChainUtil {

    private static DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl){
        CreditChainUtil.dsl = dsl;
    }

    /**
     * 共有函数，对指定企业修改信用信息
     * @param accountnum  企业账号记录主键值
     * @param creditNeedToBeUpdated 信用值变化量，可正可负
     * @param reason 信用信息更改的原因
     *
     * @return String 执行结果:
     *   "locked"  企业信用被锁定，更改无效
     *   "submitted"  任务已提交，等待更新结果
     */
    public static String updateCredit(String accountnum, int creditNeedToBeUpdated, String reason) {
        Byte locked = new Byte("1");
        CompanyRecord record = dsl.fetchOne(Company.COMPANY, Company.COMPANY.ACCOUNTNUM.eq(accountnum));
        if (record.getLock().equals(locked)){
            return "locked";
        }
        Long previousCredit = record.getCredit();
        CreditChainUtil.addTask(accountnum, previousCredit, creditNeedToBeUpdated, reason);
        return "submitted";
    }

    /**
     * 将信用更新任务提交到队列，并对指定账号加信用值锁。
     * @param accountnum
     * @param previousCredit
     * @param creditNeedToBeUpdated
     * @param reason
     */
    private static void addTask(String accountnum, Long previousCredit, int creditNeedToBeUpdated, String reason) {
        Byte locked = new Byte("1");
        long timeStamp = System.currentTimeMillis();
        String timeStampStr = String.valueOf(timeStamp);
        dsl.insertInto(Creditupdatetask.CREDITUPDATETASK)
                .set(Creditupdatetask.CREDITUPDATETASK.ACCOUNTNUM, accountnum)
                .set(Creditupdatetask.CREDITUPDATETASK.PREVIOUSCREDIT, previousCredit.intValue())
                .set(Creditupdatetask.CREDITUPDATETASK.DELTA, creditNeedToBeUpdated)
                .set(Creditupdatetask.CREDITUPDATETASK.STATE, "waiting")
                .set(Creditupdatetask.CREDITUPDATETASK.TIMESTAMP, timeStampStr)
                .set(Creditupdatetask.CREDITUPDATETASK.REASON, reason)
                .execute();
        dsl.update(Company.COMPANY)
                .set(Company.COMPANY.LOCK, locked);
    }

    /**
     * 更新信用值的定时任务，任务的状态有：
     * waiting（等待中，还未提交到区块链计算）
     * pending（处理中，已提交到区块链计算，但未出结果）
     * finished（处理完成）
     * ---------------------------
     *
     * 1. 提交事务。先检查队列中相同的 accountNum 记录中是否有不存在 pending 状态的记录，
     * 若有，则随意将其账号下的一个 waiting 的记录设为 pending 并提交给区块链执行
     *
     * 2. 检查事务状态。查询所有 状态为 pending 的记录，调用 CreditChain.getCreditOfCompany 接口，获取指定企业最新的链上信用值 presentCredit，
     * 并与此记录中的 (previousCredit + delta) 对比，若相等则将此记录的状态变为 finished，若不相等则跳过。
     *
     * 3. 解锁。查询队列中 accountNum 相同的记录中是否存在状态全为 finished 的情况，若存在，则将指定的企业信用值解锁，并将所有状态为 finished 的记录删除
     */
    // @Scheduled(fixedRate = 120)
    private static void updateCreditSchedule(){
        Byte unlocked = new Byte("0");
        // 提交事务
        Creditupdatetask T = Creditupdatetask.CREDITUPDATETASK;
        List<Integer> tasks = dsl.select().distinctOn(T.ACCOUNTNUM).where(T.STATE.ne("pending")).fetch(T.ID);
        if (!tasks.isEmpty()){
            for (Integer task: tasks){
                CreditupdatetaskRecord record = dsl.fetchOne(T, T.ID.eq(task));
                record.setState("pending");
                record.store();
                CreditChain.chain.updateGuarantyState(record.getAccountnum(), record.getPreviouscredit(), record.getDelta(), record.getTimestamp(), record.getReason());
            }

        }
        // 检查事务状态
        Result result = dsl.select().from(T).where(T.STATE.eq("pending")).fetch();
        if (result != null){
            for (Object o: result){
                Record record = (Record) o;
                String accountNum = record.getValue("AccountNum", String.class);
                Integer presentCredit = CreditChain.chain.getCreditOfCompany(accountNum);
                Integer previousCredit = record.getValue("previousCredit", Integer.class);
                Integer delta = record.getValue("delta", Integer.class);
                if (presentCredit == (previousCredit + delta)){
                    Integer taskId = record.getValue("id", Integer.class);
                    dsl.update(T)
                            .set(T.STATE, "finished")
                            .where(T.ID.eq(taskId))
                            .execute();
                }
            }
        }
        // 解锁
        Result<Record2<Integer, String>> result1 = dsl.select(T.ID, T.ACCOUNTNUM).distinctOn(T.ACCOUNTNUM).where(T.STATE.eq("finished")).fetch();
        if (result1 != null){
            for (Record2<Integer, String> record2: result1){
                dsl.update(Company.COMPANY)
                        .set(Company.COMPANY.LOCK, unlocked)
                        .execute();
                dsl.delete(T).where(T.ID.eq(record2.value1())).execute();
            }
        }

    }
}
