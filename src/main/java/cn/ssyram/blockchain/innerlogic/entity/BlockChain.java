package cn.ssyram.blockchain.innerlogic.entity;

import cn.ssyram.blockchain.innerlogic.support.ChainType;

public class BlockChain {
    ChainType type;

    public ChainType getType() {
        return type;
    }

    public void setType(ChainType type) {
        this.type = type;
    }
}
