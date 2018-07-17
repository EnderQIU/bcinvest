package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 本质上是一个带上type用于寻找合适区块的BlockData
 */
public class CollectDTO implements Serializable {
    private ChainType type;
    private List<BlockData> blockDataList;

    public CollectDTO() {}

    /**
     * 放入一条信息生成一个只含有一条信息的信息盒包装
     */
    public CollectDTO(ChainType type, BlockData data) {
        this.type = type;
        blockDataList = new ArrayList<>(1);
        blockDataList.add(data);
    }

    public ChainType getType() {
        return type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public List<BlockData> getBlockDataList() {
        return blockDataList;
    }

    public void setBlockDataList(List<BlockData> blockDataList) {
        this.blockDataList = blockDataList;
    }
}
