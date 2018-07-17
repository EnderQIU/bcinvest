package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

import java.io.Serializable;
import java.util.List;

/**
 * 本质上是一个带上type用于寻找合适区块的BlockData
 */
public class CollectDTO implements Serializable {
    private ChainType type;
    private List<BlockData> blockDataList;

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
