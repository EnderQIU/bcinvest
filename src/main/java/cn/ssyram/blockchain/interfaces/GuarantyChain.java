package cn.ssyram.blockchain.interfaces;

import cn.ssyram.blockchain.impls.GurantyChainImpl;

public interface GuarantyChain extends BlockChain {
    GuarantyChain chain = new GurantyChainImpl();
}
