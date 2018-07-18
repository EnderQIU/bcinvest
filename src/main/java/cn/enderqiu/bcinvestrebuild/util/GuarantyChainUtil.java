package cn.enderqiu.bcinvestrebuild.util;

import cn.ssyram.blockchain.interfaces.GuarantyChain;
import com.generator.tables.Company;
import com.generator.tables.Guaranty;
import com.generator.tables.Guarantystateupdatetask;
import com.generator.tables.records.CompanyRecord;
import com.generator.tables.records.GuarantyRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GuarantyChainUtil {

    private static DSLContext dsl;

    @Autowired
    public void setDSL(DSLContext dsl){
        GuarantyChainUtil.dsl = dsl;
    }

    /**
     * 检查动作是否合法
     * @param orig 当前状态
     * @param dest 目标状态
     * @return
     */
    public static boolean checkUpdateIllegal(Integer orig, Integer dest){
        boolean[][] validActionMap = {
                {false, true, true, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, true, false, false, false, false, false, },
                {false, false, true, false, true, false, false, false, false, },
                {false, false, false, false, false, true, false, false, false, },
                {false, false, false, false, true, false, true, false, false, },
                {false, false, false, false, true, false, false, false, true, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, false, true, false, false, false, false, },
        };
        return validActionMap[orig][dest];
    }

    /**
     * 检查动作是否为立即的
     * @param orig 当前状态
     * @param dest 目标状态
     * @return
     */
    public static boolean checkUpdateimmediately(Integer orig, Integer dest){
        boolean[][] immediatelyActionMap = {
                {false, true, true, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, true, false, false, false, false, false, },
                {false, false, true, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
                {false, false, false, false, false, false, false, false, false, },
        };
        return immediatelyActionMap[orig][dest];
    }

    /**
     * 检查状态转换是否涉及更新企业信用
     * @param orig
     * @param dest
     * @return
     */
    public static int checkHowMuchCreditNeedToBeUpdated(Integer orig, Integer dest){
        int[][] needUpdateCreditActionMap = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, -50, 0, 0, 0, +20, },  // 逾期，-50；逾期还款，+20
                {0, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 0, 0, +30, 0, 0, 0, 0, },  // 期限内还款，+30
        };
        return needUpdateCreditActionMap[orig][dest];
    }

    /**
     * 判断参数是否合法，
     * 若任务是立即的，则立即更新状态，不加锁
     * 若任务是需要等待的，则加锁，并调用`添加任务到队列中`的私有函数
     * @param guarantyId
     * @param stateWillUpdateTo
     */
    public static void updateState(Integer guarantyId, Integer stateWillUpdateTo){
        Guaranty T = Guaranty.GUARANTY;
        GuarantyRecord record = dsl.fetchOne(T, T.GUARANTYID.eq(guarantyId));
        Byte locked = 1;
        Byte unlocked = 0;
        if (record == null){
            // 记录不存在，不允许更改
            return;
        }
        if (record.getLock().equals(locked)){
            // 锁有效，不允许更改
            return;
        }
        Integer presentState = record.getState();
        if (!GuarantyChainUtil.checkUpdateIllegal(record.getState(), stateWillUpdateTo)){
           // 无效的状态更改
            return;
        }
        if (GuarantyChainUtil.checkUpdateimmediately(record.getState(), stateWillUpdateTo)){
            // 有效的立即的状态更改，立即更改状态
            record.setState(stateWillUpdateTo);
            record.store();
            return;
        }
        // 接下来处理有效的非立即的状态转换
        addTask(guarantyId, record.getState(), stateWillUpdateTo);
        record.setLock(locked);  // 加锁
        record.store();
    }

    /**
     * 添加任务到队列中，私有函数，已经在共有函数中校验过参数合法
     * @param guarantyId
     * @param previousState
     * @param stateWillUpdateTo
     */
    private static void addTask(Integer guarantyId, Integer previousState, Integer stateWillUpdateTo){
        Guarantystateupdatetask T = Guarantystateupdatetask.GUARANTYSTATEUPDATETASK;
        dsl.insertInto(T)
                .set(T.GUARANTYID, guarantyId)
                .set(T.PREVIOUSSTATE, previousState)
                .set(T.STATEWILLUPDATETO, stateWillUpdateTo)
                .set(T.TASKSTATE, "pending").execute();
    }

    /**
     * 检查是否超时未还款，若超时则更改状态为 Overdue(6)
     */
    private void checkOverdue(){

    }

    /**
     * rate =  1 min
     * 遍历队列中任务状态为 pending 的任务，检查状态是否更新为想要的状态，
     * 若状态更新为想要的状态，则将队列的状态字段更改为 success 并更新 guaranty 表中记录，
     * 若状态未更新且 count 小于等于 180，则将 count + 1，
     * 若状态未更新且 count 大于 180，则将此记录状态设为 failure。
     */
    //@Scheduled(fixedRate = 10)
    public void checkStateWhetherUpdate(){
        Byte locked = 1;
        Byte unlocked = 0;
        Guarantystateupdatetask T = Guarantystateupdatetask.GUARANTYSTATEUPDATETASK;
        Result result = dsl.fetch(T, T.TASKSTATE.eq("pending"));
        for (Object o: result){
            Record record = (Record) result;
            Integer presentStateFromBlockChain = GuarantyChain.chain.getGuarantyState(record.getValue("guarantyId", Integer.class));
            Integer stateWillUpdateTo = record.getValue("stateWillUpdateTo", Integer.class);
            if (presentStateFromBlockChain.equals(stateWillUpdateTo)){
                // 状态装换完成，更新状态，解锁
                dsl.update(T).set(T.TASKSTATE, "success").where(T.TASKID.eq(record.getValue("taskId", Integer.class))).execute();
                dsl.update(Guaranty.GUARANTY)
                        .set(Guaranty.GUARANTY.STATE, record.getValue("stateWillUpdateTo", Integer.class))
                        .set(Guaranty.GUARANTY.LOCK, unlocked).execute();
                // 判断是否需要更新信用信息，若需要，则调用 CreditChainUtil.updateCredit()
                int creditNeedToBeUpdated = GuarantyChainUtil.checkHowMuchCreditNeedToBeUpdated(record.getValue("previousState", Integer.class), stateWillUpdateTo);
                if ( creditNeedToBeUpdated != 0){
                    GuarantyRecord record1 = dsl.fetchOne(Guaranty.GUARANTY, Guaranty.GUARANTY.GUARANTYID.eq(record.getValue("guarantyId", Integer.class)));
                    CreditChainUtil.updateCredit(record1.getAccountnum(), creditNeedToBeUpdated);
                }
            }else{
                Integer count = record.getValue("count", Integer.class);
                if (count <= 180){
                    count += 1;
                    dsl.update(T).set(T.COUNT, count).where(T.TASKID.eq(record.getValue("taskId", Integer.class))).execute();
                }else {
                    dsl.update(T).set(T.TASKSTATE, "failure").where(T.TASKID.eq(record.getValue("taskId", Integer.class))).execute();
                    // 解锁
                    GuarantyRecord r = dsl.fetchOne(Guaranty.GUARANTY, Guaranty.GUARANTY.GUARANTYID.eq(record.getValue("guarantyId", Integer.class)));
                    r.setLock(unlocked);
                    r.store();
                }
            }
        }
    }

    /**
     * 检查抵押物是否锁定
     * @param guarantyId 抵押物 ID
     * @return 是否锁定
     */
    public static boolean checkIfLocked(Integer guarantyId){
        Byte locked = 1;
        Byte unlocked = 0;
        GuarantyRecord r = dsl.fetchOne(Guaranty.GUARANTY, Guaranty.GUARANTY.GUARANTYID.eq(guarantyId));
        Byte lockState = r.getLock();
        if (lockState.equals(locked)){
            return true;
        }else{
            return false;
        }
    }
}
