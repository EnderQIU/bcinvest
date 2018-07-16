package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import cn.ssyram.blockchain.innerlogic.support.ChainType;

/**
 * 本质上是一个带上type用于寻找合适区块的BlockData
 */
public class CollectDTO {
    private ChainType type;
    private BlockData blockData;

    public ChainType getType() {
        return type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }

    public BlockData getBlockData() {
        return blockData;
    }

    public void setBlockData(BlockData blockData) {
        this.blockData = blockData;
    }
}
