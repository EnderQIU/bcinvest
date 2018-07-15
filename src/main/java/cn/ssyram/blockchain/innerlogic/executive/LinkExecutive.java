package cn.ssyram.blockchain.innerlogic.executive;

import cn.ssyram.blockchain.innerlogic.dto.LinkDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;

/**
 * Executive包
 * <p>
 * Link过程的执行者
 * 其run方法即开始执行的程序
 */
public class LinkExecutive implements Runnable {
    private Block block;

    public LinkExecutive(LinkDTO dto) {
        this.block = dto.getBlock();
    }

    @Override
    public void run() {

    }
}
