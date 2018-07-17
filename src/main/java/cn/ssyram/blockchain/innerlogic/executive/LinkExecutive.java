package cn.ssyram.blockchain.innerlogic.executive;

import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import cn.ssyram.blockchain.innerlogic.dto.LinkDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.operator.BlockChainOperator;
import cn.ssyram.blockchain.innerlogic.operator.BlockOperator;
import cn.ssyram.blockchain.innerlogic.support.*;
import cn.ssyram.blockchain.innerlogic.test.Logger;
import com.bcgenerator.tables.Addresslist;
import com.bcgenerator.tables.CreditChain;
import com.bcgenerator.tables.GuarantyChain;
import com.bcgenerator.tables.records.AddresslistRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executive包
 * <p>
 * Link过程的执行者
 * 其run方法即开始执行的程序
 */
@Component
public class LinkExecutive implements Runnable {
    @Autowired
    DSLContext dsl;
    private Block block;
    //    /**
//     * previous_hash线程池
//     * 根据previous_hash分配相应的线程池进行执行
//     * 每个线程池都是固定的单线程线程池，只允许一个任务进入
//     */
//    private static Map<String, ExecutorService> previous_hashPools = new HashMap<>();
//    private static ExecutorService verifierExePool = Executors.newCachedThreadPool();
    private static ExecutorService service = Executors.newCachedThreadPool();

    /**
     * 真正的验证线程
     */
    private class Verifier implements Runnable {
        @Override
        public void run() {
            execute();
        }

        private void execute() {
            //数据添加之前会有一次检查，如果已经有相同的先插入则也不能进行下一步
            //无论检查通过与否都要释放读者锁
            if (!verify() || !dataAppendation()) {
                readerPermissionRelease();
                return;
            }

            readerPermissionRelease();

            if (!ConditionVariables.calculating) return;

            sendBlock();
        }

        private void sendBlock() {
            Transferer.send(block);
        }

        private String isLongestSelectSentence(boolean only) {
            return "SELECT * FROM " + block.getType().getChainTableName() + " WHERE length" + (only ? ">=" : ">") + "ALL (SELECT length FROM " + block.getType().getChainTableName() + " WHERE this_hash = " + block.getThis_hash() + ");";
        }

        private boolean dataAppendation() {
            synchronized (LockInstances.databaseLocks.get(block.getType().toString())) {
                //再检查一遍是否有相同的this_hash
                if (alreadyHave()) return false;
                //加入数据
                appendData();

                List<Map<String, Object>> r = DatabaseOperator.SELECT(isLongestSelectSentence(true));

                //存在比这个块加进去以后长度相等或更长的块
                //即不是唯一最长
                if (r.size() != 0) {
                    if (ConditionVariables.calculating) {
                        r = DatabaseOperator.SELECT(isLongestSelectSentence(false));
                        //没有比它加进去以后更长的块
                        //即这个已经是最长
                        if (r.size() != 0) ConditionVariables.shouldGiveUp = true;
                    }
                    return true;
                }

                //是唯一最长
                if (ConditionVariables.calculating) ConditionVariables.shouldGiveUp = true;

                //改主链
                changeMainChain();

                return true;
            }
        }

        private void changeMainChain() {
            //一次溯源
            //在计算data的时候已经算完了
            //使用notMainHashList即可获得当前块前一块到主链为止所有非main的hash，所以加上本块hash即完成构建
            //使用nearestMainLength就是到最近邻main块的主链长
            notMainHashList.add(block.getThis_hash());
            //两次批量修改
            //通过最近邻主链块的长将当前的主链变为非主链
            deIs_MainByNearestMainLength();
            //将当前块的链改为主链
            letIs_MainByHashListToMain();
        }

        private void letIs_MainByHashListToMain() {
            String updateSentence =
                    "UPDATE " + block.getType().getChainTableName()
                    + " SET is_main = 1"
                    + " WHERE this_hash IN(";
            StringBuilder valueSet = new StringBuilder();
            for (String this_hash:notMainHashList)
                valueSet.append(this_hash).append(",");
            valueSet.deleteCharAt(valueSet.length() - 1);
            updateSentence += valueSet + ");";
            Logger.logger.info(
                    "Run SQL in letIs_MainByHashListToMain: "
                    + updateSentence
            );
            DatabaseOperator.UPDATE(updateSentence);
        }

        private void deIs_MainByNearestMainLength() {
            DatabaseOperator.UPDATE(
                    "UPDATE " + block.getType().getChainTableName()
                    + " SET is_main = 2 "
                    + "WHERE "
                    + "is_main = 1 AND "
                    + "length > " + nearestMainLength
                    + " AND length <= ALL ("
                    + "SELECT MAX(length) FROM" + block.getType().getChainTableName()
                    + " GROUP BY is_main HAVING is_main = 1"
                    + ");"
            );
        }

        private void appendData() {
            BlockChainOperator.addBlock(block, false);
        }


        /**
         * verify四大要求：<br />
         *     this_hash有效<br />
         *     数据有效<br />
         *     不是已经有的块 //这个需要在数据插入之前再检查一遍<br />
         *     previous_hash能够找到<br />
         *
         * @return 合法与否
         */
        private boolean verify() {
            //线性确认
            return (!alreadyHave())
                    || (!noSuchPrevious_Hash())
                    || verifyDataList()
                    || verifyThis_Hash();
        }

        private boolean verifyThis_Hash() {
            return BlockOperator.hasValidThis_Hash(block);
        }

        private boolean verifyDataList() {
            List<BlockData> dataList = block.getDataList();
            if (dataList.size() == 0) return true;

            //找到相关物品的当前状态并且填充到idNearestCondition的List中
            fillIdNearestCondition();
//            fillNotMainHashListAndNearestMainLength();
            for (BlockData data : dataList) {
                if (!validConditionChange(idNearestCondition.get(data.getId()), data)) return false;

                //暂时为了效率放弃检查variation和目标转换值是否对应
//                if (!validConditionVariationAction(
//                        data.getVariation()
//                ))
            }
            return true;
        }

        private boolean validConditionChange(String s, BlockData data) {
            if (block.getType() == ChainType.guaranty)
                return GuarantyChainUtil.checkUpdateIllegal(Integer.valueOf(s), Integer.valueOf(data.getValue()));
            if (block.getType() == ChainType.credit)
                return Integer.valueOf(s) + Integer.valueOf(data.getVariation()) == Integer.valueOf(data.getValue());
            throw new RuntimeException("No such type");
        }

        /**
         * 表示从当前块的前一块开始所有非主链元素的值
         */
        private List<String> notMainHashList;
        private int nearestMainLength;
        Map<String, String> idNearestCondition;

        private void fillIdNearestCondition() {
            //为下文getCons，填充非主链路径的hash与最近的主链节点的链长
            fillNotMainHashListAndNearestMainLength();

            //从数据库获得原始的最近数据
            List<Map<String, Object>> cons = getCons();

            for (Map<String, Object> con : cons)
                idNearestCondition.put((String) con.get("id"), (String) con.get("value"));
        }

        private List<Map<String, Object>> getCons() {
            StringBuilder inner = new StringBuilder("SELECT id, value, MAX(length) FROM ").append(block.getType().getChainTableName()).append("JOIN ").append(block.getType().getDataTableName()).append("ON this_hash = block_hash WHERE (is_main = 1");

            if (notMainHashList.size() != 0) {
                StringBuilder this_hashList = new StringBuilder("AND length <= ");
                this_hashList.append(nearestMainLength).append(" OR this_hash IN (");
                for (String hash : notMainHashList)
                    this_hashList.append(hash).append(",");
                this_hashList.deleteCharAt(this_hashList.length() - 1);
                inner.append(this_hashList).append(")");
            }
            inner.append(") AND id IN (");
            for (BlockData data : block.getDataList())
                inner.append(data.getId()).append(",");
            inner.replace(inner.length() - 1, inner.length(), ");");

            String tempViewName = "tempTable" + block.getThis_hash();
            StringBuilder createTempView = new StringBuilder("CREATE VIEW ");
            createTempView.append(tempViewName).append(" AS").append(inner);

            StringBuilder select = new StringBuilder("SELECT id, value FROM ");
            select.append(createTempView).append("AS One ").append("WHERE length = ").append("(SELECT MAX(length) FROM ").append(createTempView).append("AS Two ").append("WHERE One.id = Two.id;");
            DatabaseOperator.SELECT(createTempView.toString());
            List<Map<String, Object>> result = DatabaseOperator.SELECT(select.toString());
            DatabaseOperator.SELECT("DROP VIEW " + tempViewName);

            return result;
        }

        private void fillNotMainHashListAndNearestMainLength() {
            notMainHashList = new ArrayList<>();
            Map<String, Object> selectResult = getPreviousBlock(block.getPrevious_hash());
            while ((Boolean) selectResult.get("is_main")) {
                notMainHashList.add((String) selectResult.get("this_hash"));
                selectResult = getPreviousBlock((String) selectResult.get("previous_hash"));
            }
            nearestMainLength = (int) selectResult.get("length");
        }

        /**
         * 获得目标的前一块的信息
         * @param previous_hash 目标的前一块的hash值
         * @return 目标的前一块的Map信息，对应列
         */
        private Map<String, Object> getPreviousBlock(String previous_hash) {
            return DatabaseOperator.SELECT("SELECT * FROM "
                    + block.getType().getChainTableName()
                    + "WHERE this_hash = "
                    + previous_hash
                    + ";"
            ).get(0);
        }

        private boolean noSuchPrevious_Hash() {
            Record record = null;
            if (block.getType() == ChainType.credit)
                record = dsl.fetchOne(CreditChain.CREDIT_CHAIN, CreditChain.CREDIT_CHAIN.THIS_HASH.eq(block.getPrevious_hash()));
            else if (block.getType() == ChainType.guaranty)
                record = dsl.fetchOne(GuarantyChain.GUARANTY_CHAIN, GuarantyChain.GUARANTY_CHAIN.THIS_HASH.eq(block.getPrevious_hash()));

            return record == null;
        }

        private boolean alreadyHave() {
            Record record = null;
            if (block.getType() == ChainType.credit)
                record = dsl.fetchOne(CreditChain.CREDIT_CHAIN, CreditChain.CREDIT_CHAIN.THIS_HASH.eq(block.getThis_hash()));
            else if (block.getType() == ChainType.guaranty)
                record = dsl.fetchOne(GuarantyChain.GUARANTY_CHAIN, GuarantyChain.GUARANTY_CHAIN.THIS_HASH.eq(block.getThis_hash()));

            return record != null;
        }

        private void readerPermissionRelease() {
            synchronized (ConditionVariables.linkerAmountWhenCalculating) {
                --ConditionVariables.linkerAmountWhenCalculating;
                if (ConditionVariables.linkerAmountWhenCalculating == 0)
                    Semaphores.blockchain.release();
            }
        }
    }

    public LinkExecutive(LinkDTO dto) {
        this.block = dto.getBlock();
    }

    //    /**
//     * previous_hash流程：
//     * 找到相应的线程池，放入任务
//     * 任务都是固定的，执行完毕以后对当前执行线程进行唤醒
//     */
    @Override
    public void run() {
        execute();
    }

    private void execute() {
        addressVerify();
        readerPermissionVerify();

        blockVerify();
    }

    private void blockVerify() {
        //获得合适的线程池进入执行，不占用请求的线程池，尽早完成请求
//        ExecutorService service = getExecutorService();
        Verifier verifier = new Verifier();
        service.execute(verifier);
    }

//    private ExecutorService getExecutorService() {
//        ExecutorService service = previous_hashPools.get(block.getPrevious_hash());
//        if (service != null)
//            return service;
//        service = Executors.newSingleThreadExecutor();
//        previous_hashPools.put(block.getPrevious_hash(), service);
//        return service;
//    }

    private void readerPermissionVerify() {
        synchronized (ConditionVariables.linkerAmountWhenCalculating) {
            if (ConditionVariables.linkerAmountWhenCalculating == 0) {
                try {
                    Semaphores.blockchain.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ++ConditionVariables.linkerAmountWhenCalculating;
        }
    }

    private void addressVerify() {
        if (!addressInDatabase()) addAddressToDatabase();
    }

    private void addAddressToDatabase() {
        dsl.insertInto(Addresslist.ADDRESSLIST).columns(Addresslist.ADDRESSLIST.ADDRESS).values(block.getAddress());
    }

    private boolean addressInDatabase() {
//        Result r = dsl.select().from(Addresslist.ADDRESSLIST)/*.asTable("a").join(Addresslist
//                .ADDRESSLIST).on(Addresslist.ADDRESSLIST.ADDRESS.eq(Addresslist.ADDRESSLIST
//                .ADDRESS))*/.where(Addresslist.ADDRESSLIST.ADDRESS.eq(address)).fetch();
//        for (Object o:r) {
//            Record record = (Record)o;
//            record.getValue("Address", String.class);
//        }

        AddresslistRecord record = dsl.fetchOne(Addresslist.ADDRESSLIST, Addresslist.ADDRESSLIST.ADDRESS.eq(block.getAddress()));

        return record != null;
    }
}
