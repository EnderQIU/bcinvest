package cn.ssyram.blockchain.impls;

import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CCGuarantyChainInterfaceImpl implements CCGuarantyChainInerface{
    @Override
    public int insertGuaranty(int guarantyId){
        return 0;
    }
    @Override
    public int deleteGuaranty(int guarantyId){
        return 0;
    }
    @Override
    public List<Map<String, Object>> queryGuarantyIdByState(int state){
        return null;
    }
    @Override
    public List<Map<String, Object>> query(String id) {
        return null;
    }
    @Override
    public int updateState(int guarantyId,int state){
        return 0;
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
