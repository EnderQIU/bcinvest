package cn.ssyram.blockchain.innerlogic.executive;

import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BufferBlock;
import cn.ssyram.blockchain.innerlogic.operator.BlockChainOperator;
import cn.ssyram.blockchain.innerlogic.operator.Miner;
import cn.ssyram.blockchain.innerlogic.support.*;

import java.util.Calendar;

public class MineExecutive implements Runnable {
    private ChainType type;
    private BufferBlock block;
    /**
     * 需要等待的分钟数
     */
    private int waitMinutes;

    /**
     * 建立新的挖矿机并且指定挖矿周期
     * @param type 挖矿机开始挖矿
     * @param waitMinutes 挖矿周期
     */
    public MineExecutive(ChainType type, int waitMinutes) {
        this.type = type;
        this.waitMinutes = waitMinutes;
    }

    @Override
    public void run() {
        try {
            execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void execute() throws InterruptedException {
        //从程序开始永不停息
        while (true) {
            wait(waitMinutes * 60 * 1000);

            fillRawBlock();

            Semaphores.blockchain.acquire();

            //临界资源：说明正式开始计算新的块
            ConditionVariables.calculating = true;
            ConditionVariables.shouldGiveUp = false;

            block.setAddress(GlobalInfo.SELF_ADDRESS);
            block.setTimeStamp(Calendar.getInstance().getTime().toString());
            Miner miner = new Miner();

            while (true) {
                miner.getNewThis_Hash(block);

                //检测有没有新送来的块，先验证
                Semaphores.blockchain.release();
                Semaphores.blockchain.acquire();

                //如果验证完了合法且别人已经完成了自身工作
                //退出本次挖矿，无论自身是否已经挖出来
                if (ConditionVariables.shouldGiveUp)
                    break;

                //检验是否合法，且用的是byte直接检验
                if (!miner.hasValidThis_Hash(block))
                    continue;

                //发布新的矿块
                releaseOre();

                break;
            }
        }
    }

    private void releaseOre() {
        //从缓冲区块得到便于发送的区块
        //所有信息已经填充完整
        Block b = block.getBlock();

        if (!BlockChainOperator.blockContentVerify(b ,true))
            return;

        BlockChainOperator.addBlock(b, true);

        Transferer.send(b);
    }

    private void fillRawBlock() {
        synchronized (LockInstances.tempblocks.get(type.toString())) {
            block = CurrentBlocks.replaceCurrentBlockFor(type);
        }
    }
}
