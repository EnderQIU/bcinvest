package cn.ssyram.blockchain.interfaces;

/**
 * Created by EvanChoo on 7/15/18.
 */

public interface EvanGuarantyChainInterface extends GuarantyChain {
    /**
     * 强制某个抵押物下链，添加删除信息到区块链
     * @param guarantyId
     * @return 删除成功返回1，删除失败或者没有这个抵押物返回0
     */
    int deleteGuaranty(int guarantyId);
}
