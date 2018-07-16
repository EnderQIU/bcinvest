package cn.ssyram.blockchain.interfaces;

import cn.ssyram.blockchain.impls.GurantyChainImpl;

import java.util.ArrayList;

public interface GuarantyChain extends BlockChain {
    GuarantyChain chain = new GurantyChainImpl();

    void updateGuarantyState(Integer guarantyId, Integer stateWillUpdateTo);

    Integer getGuarantyState(Integer guarantyId);

    ArrayList<Integer> getGuarantyState(ArrayList<Integer> guarantyIds);
}
