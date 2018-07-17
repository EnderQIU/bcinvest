package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.Block;

import java.io.Serializable;

/**
 * 本质上就是一个Block
 */
public class LinkDTO implements Serializable {
    private Block block;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
