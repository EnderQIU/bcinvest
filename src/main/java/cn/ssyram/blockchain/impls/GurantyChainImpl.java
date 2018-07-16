package cn.ssyram.blockchain.impls;

import cn.ssyram.blockchain.interfaces.GuarantyChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GurantyChainImpl implements GuarantyChain {
    @Override
    public List<Map<String, Object>> query(String id) {
        return null;
    }

    @Override
    public void updateGuarantyState(Integer guarantyId, Integer stateWillUpdateTo) {

    }

    @Override
    public Integer getGuarantyState(Integer guarantyId) {
        return null;
    }

    @Override
    public ArrayList<Integer> getGuarantyState(ArrayList<Integer> guarantyIds) {
        return null;
    }
}
