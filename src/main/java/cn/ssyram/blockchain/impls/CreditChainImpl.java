package cn.ssyram.blockchain.impls;

import cn.ssyram.blockchain.innerlogic.DatabaseOperator;
import cn.ssyram.blockchain.innerlogic.Dispatcher;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.dto.QueryDTO;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;
import cn.ssyram.blockchain.interfaces.CreditChain;

import java.util.List;
import java.util.Map;

public class CreditChainImpl implements CreditChain {
    private static ChainType type = ChainType.credit;
    @Override
    public List<Map<String, Object>> query(String id) {
        return null;
    }

//    @Override
//    public void updateGuarantyState(String accountNum, Integer previousCredit, Integer delta) {
//        BlockData data = new BlockData();
//        data.setId(accountNum);
//        data.setVariation(delta.toString());
//        Integer value = previousCredit + delta;
//        data.setValue(value.toString());
//
//        Dispatcher.collect(new CollectDTO(type, data));
//    }

    @Override
    public void updateGuarantyState(String accountNum, Integer previousCredit, Integer delta, String timestamp, String reason) {
        BlockData data = new BlockData();
        data.setId(accountNum);
        data.setVariation(delta.toString());
        Integer value = previousCredit + delta;
        data.setValue(value.toString());
        data.setRemarks(timestamp + "-" + reason);

        Dispatcher.collect(new CollectDTO(type, data));
    }

    @Override
    public Integer getCreditOfCompany(String accountNum) {
        String sentence =
                "SELECT value FROM " + type.getReadyMainChainViewName()
                + " WHERE id = '" + accountNum + "'";

        List<Map<String, Object>> l = Dispatcher.query(new QueryDTO(type, sentence));

        if (l.size() == 0)
            return -1;

        return Integer.valueOf(
                (String) l.get(0).get("value")
        );
    }

    @Override
    public List<Map<String, Object>> getCompanyCreditList(String accountNum) {
        return DatabaseOperator.SELECT(
                "SELECT DISTINCT * FROM "
                        + type.getChainTableName() + " JOIN " + type.getDataTableName()
                        + " ON this_hash = block_hash"
                        + " WHERE id = '" + accountNum + "'"
        );
    }
}
