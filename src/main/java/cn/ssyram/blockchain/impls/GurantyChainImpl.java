package cn.ssyram.blockchain.impls;

import cn.ssyram.blockchain.innerlogic.Dispatcher;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.dto.QueryDTO;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;
import cn.ssyram.blockchain.innerlogic.DatabaseOperator;
import cn.ssyram.blockchain.interfaces.GuarantyChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GurantyChainImpl implements GuarantyChain {
    private static ChainType type = ChainType.guaranty;
    @Override
    public List<Map<String, Object>> query(String id) {
        return null;
    }

    @Override
    public void updateGuarantyState(Integer guarantyId, Integer stateWillUpdateTo) {
        BlockData data = new BlockData();
        data.setId(guarantyId.toString());
        data.setValue(stateWillUpdateTo.toString());

        List<BlockData> dataList = new ArrayList<>(1);
        dataList.add(data);

        CollectDTO dto = new CollectDTO();
        dto.setType(ChainType.guaranty);
        dto.setBlockDataList(dataList);

        Dispatcher.collect(dto);
    }

    @Override
    public Integer getGuarantyState(Integer guarantyId) {
        ChainType type = ChainType.guaranty;
        String sentence =
                "SELECT id, value" +
                        "FROM " + type.getReadyMainChainViewName() +
                        " WHERE id = " + guarantyId.toString();

        return Integer.valueOf(
                (String) Dispatcher.query(
                        new QueryDTO(type, sentence)
                ).get(0).get("value")
        );
    }

    @Override
    public int insertGuaranty(int guarantyId) {
        if (DatabaseOperator.SELECT(
                "SELECT * FROM " + type.getMainChainViewName()
                + " WHERE id = " + guarantyId
        ).size() != 0)
            return 0;

        BlockData data = new BlockData();
        data.setId(guarantyId + "");
        data.setValue(4 + "");

        return Dispatcher.collect(new CollectDTO(type, data));
    }

    @Override
    public int deleteGuaranty(int guarantyId) {
        BlockData data = new BlockData();
        data.setId(guarantyId + "");
        data.setValue(1 + "");

        return Dispatcher.collect(new CollectDTO(type, data));
    }

    @Override
    public List<Map<String, Object>> queryGuarantyIdByState(int state) {
        String sentence =
                "SELECT id FROM " + type.getReadyMainChainViewName()
                + " WHERE value = " + state;

        return Dispatcher.query(new QueryDTO(type, sentence));
    }
}
