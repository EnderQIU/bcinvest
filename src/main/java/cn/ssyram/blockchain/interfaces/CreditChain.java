package cn.ssyram.blockchain.interfaces;

import cn.ssyram.blockchain.impls.CreditChainImpl;

public interface CreditChain extends BlockChain {
    CreditChain chain = new CreditChainImpl();
}
