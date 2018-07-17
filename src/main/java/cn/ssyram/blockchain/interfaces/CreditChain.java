package cn.ssyram.blockchain.interfaces;

import cn.ssyram.blockchain.impls.CreditChainImpl;

public interface CreditChain extends BlockChain {
    CreditChain chain = new CreditChainImpl();

    /**
     * 更新指定企业的信用
     * @param accountNum
     * @param previousCredit
     * @param delta
     */
    void updateGuarantyState(String accountNum, Integer previousCredit, Integer delta);

    /**
     * 获取指定企业的信用值
     * @param accountNum
     * @return
     */
    Integer getCreditOfCompany(String accountNum);
}