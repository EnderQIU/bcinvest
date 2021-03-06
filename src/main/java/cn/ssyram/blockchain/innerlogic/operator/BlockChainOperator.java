package cn.ssyram.blockchain.innerlogic.operator;

import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import cn.ssyram.blockchain.innerlogic.DatabaseOperator;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.util.*;

public class BlockChainOperator {
    private static long getLength(Block block) {
        List<Map<String, Object>> r = DatabaseOperator.SELECT(
                "SELECT length FROM " + block.getType().getChainTableName() + " WHERE this_hash =" +
                        " " +
                        "'" + block.getPrevious_hash() + "'"
        );

        return (long)r.get(0).get("length") + 1;
    }
    public static void addBlock(Block block, boolean on_main) {
        long length = getLength(block);
        DatabaseOperator.INSERT("INSERT INTO "
                + block.getType().getChainTableName()
                + "(this_hash, time_stamp, previous_hash, length, is_main, address) "
                + "VALUES ('" + block.getThis_hash() + "', '"
                + block.getTime_stamp() + "', '"
                + block.getPrevious_hash() + "', "
                + length + ", "
                + (on_main ? "1, '" : "2, '")
                + block.getAddress()
                + "');"
        );

        String dataTableName = block.getType().getDataTableName();
        String hash = block.getThis_hash();
        for (BlockData data : block.getDataList())
            DatabaseOperator.INSERT("INSERT INTO "
                    + dataTableName
                    + "(block_hash, id, variation, value, remarks)"
                    + "VALUES ('"
                    + hash + "', '"
                    + data.getId() + "', '"
                    + data.getVariation() + "', '"
                    + data.getValue() + "', '"
                    + data.getRemarks()
                    + "');"
            );
    }

    public static Map<String, Object> getLatestMainBlockInfo(ChainType type) {
        return DatabaseOperator.SELECT(
                "SELECT * FROM " + type.getMostFrontMainBlockInfoViewName()
        ).get(0);
    }

    public static boolean blockContentVerify(Block block, boolean on_main) {
        if (on_main)
            return mainChainCheck(block);
        else
            //另外一个是link中的check，但是因为和link嵌套太过复杂，暂时不做，保留在link
            //因此这个不会被调用到
            return true;
    }

    private static boolean mainChainCheck(Block block) {
        if (block.getDataList().size() == 0)
            return true;

        Map<String, String> id_value = getPreviousConditionOnMainChainFor(block);

        for (BlockData data:block.getDataList())
            if (!validChange(
                    block.getType(),
                    id_value.get(data.getId()),
                    data
            ))
                return false;

        return true;
    }

    private static Map<String, String> getPreviousConditionOnMainChainFor(Block block)
    {
        StringBuilder idSet = new StringBuilder("(");
        for (BlockData data:block.getDataList())
            idSet.append(data.getId()).append(",");
        idSet.replace(idSet.length() - 1, idSet.length(), ")");
        //获得当前的主链上的所有id的相应状态
        List<Map<String, Object>> result = DatabaseOperator.SELECT(
                "SELECT * FROM " + block.getType().getMainChainViewName()
                        + " WHERE id IN " + idSet
        );

        //标记已经处理过的block的dataList中的id
        Map<String, String> id_value = new HashMap<>();
        for (Map<String, Object> map:result)
            id_value.put((String)map.get("id"), (String)map.get("value"));
        return id_value;
    }

    public static void blockContentTrim(Block block, boolean is_main) {
        if (block.getDataList().size() == 0) return;

        Map<String, String> id_value = getPreviousConditionOnMainChainFor(block);

        List<BlockData> dataList = block.getDataList();

        for (int i = 0; i < block.getDataList().size(); ++i) {
            if (!validChange(
                    block.getType(),
                    id_value.get(dataList.get(i).getId()),
                    dataList.get(i)
            ))
            {
                block.getDataList().remove(i);
                --i;
            }
        }
    }

    private static boolean validChange(ChainType type, String originValue, BlockData data) {
        if (type == ChainType.credit)
            if (originValue == null)
                return creditValid(
                    0,
                    Integer.valueOf(data.getValue()),
                    Integer.valueOf(data.getVariation())
            );
            else return creditValid(
                    Integer.valueOf(originValue),
                    Integer.valueOf(data.getValue()),
                    Integer.valueOf(data.getVariation())
            );
        else if (type == ChainType.guaranty)
            //如果是新設定的狀態，只能是變成可抵押的狀態
            if (originValue == null)
                return Integer.valueOf(data.getValue()) == 4;
            else return guarantyValid(
                    Integer.valueOf(originValue),
                    Integer.valueOf(data.getValue())
            );
        return false;
    }

    private static boolean guarantyValid(int originValue, int value) {
        return GuarantyChainUtil.checkUpdateIllegal(originValue, value);
    }

    private static boolean creditValid(int originValue, int value, int variation) {
        return originValue + variation == value;
    }

    public static Map<String, Object> getLatestReadyMainBlockInfo(ChainType type) {
        return DatabaseOperator.SELECT(
                "SELECT * FROM " + type.getChainTableName()
                + " WHERE is_main = 1 AND (length + 6) IN (SELECT MAX(length) FROM "
                + type.getChainTableName() + ")"
        ).get(0);
    }
}
