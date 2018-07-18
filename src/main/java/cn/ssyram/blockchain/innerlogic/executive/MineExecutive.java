package cn.ssyram.blockchain.innerlogic.executive;

import cn.ssyram.blockchain.innerlogic.CurrentBlocks;
import cn.ssyram.blockchain.innerlogic.Dispatcher;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.operator.BlockChainOperator;
import cn.ssyram.blockchain.innerlogic.operator.Miner;
import cn.ssyram.blockchain.innerlogic.support.*;
import cn.ssyram.blockchain.innerlogic.test.Logger;

public class MineExecutive extends Thread {
    private ChainType type;
    private Block block;
    /**
     * 需要等待的分钟数
     */
    private double waitMinutes;

    /**
     * 建立新的挖矿机并且指定挖矿周期
     * @param type 挖矿机开始挖矿
     * @param waitMinutes 挖矿周期
     */
    public MineExecutive(ChainType type, double waitMinutes) {
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
        synchronized (this) {
            Logger.logger.info("Miner of type " + type + " start working.");
            //从程序开始永不停息
            while (true) {
                wait((long)(waitMinutes * 60 * 1000));

                fillBlock();

                Semaphores.blockchains.get(block.getType()).acquire();
                Logger.logger.info("Miner of type " + type + " start mining.");

                //临界资源：说明正式开始计算新的块
                ConditionVariables.calculating = true;
                ConditionVariables.shouldGiveUp = false;
                Miner miner = new Miner();

                while (true) {
                    miner.getNewThis_Hash(block);

                    //检测有没有新送来的块，先验证
                    Semaphores.blockchains.get(block.getType()).release();
                    Semaphores.blockchains.get(block.getType()).acquire();

                    //如果验证完了合法且别人已经完成了自身工作
                    //退出本次挖矿，无论自身是否已经挖出来
                    if (ConditionVariables.shouldGiveUp) {
                        Semaphores.blockchains.get(block.getType()).release();
                        break;
                    }

                    //检验是否合法，且用的是byte直接检验
                    if (!miner.hasValidThis_Hash(block)) continue;

                    //发布新的矿块
                    releaseOre();

                    Semaphores.blockchains.get(block.getType()).release();
                    break;
                }
            }
        }
    }

    private void releaseOre() {
        BlockChainOperator.blockContentTrim(block ,true);

        Logger.log("Find potential ore of type " + type + ", hash: " + block.getThis_hash());

        BlockChainOperator.addBlock(block, true);

        Dispatcher.recallBlockInfo(block);

        Transferer.send(block);
    }

    private void fillBlock() {
        synchronized (LockInstances.tempblocks.get(type.toString())) {
            block = CurrentBlocks.replaceCurrentBlockFor(type).getBlock();
        }
    }
}
