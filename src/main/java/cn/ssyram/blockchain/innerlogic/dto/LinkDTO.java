package cn.ssyram.blockchain.innerlogic.dto;

import cn.ssyram.blockchain.innerlogic.entity.Block;

/**
 * 本质上就是一个Block
 */
public class LinkDTO {
    private Block block;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
