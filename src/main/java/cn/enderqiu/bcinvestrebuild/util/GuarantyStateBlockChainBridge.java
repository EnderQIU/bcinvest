package cn.enderqiu.bcinvestrebuild.util;

import java.util.ArrayList;

public interface GuarantyStateBlockChainBridge {

    void updateGuarantyState(Integer guarantyId, Integer stateWillUpdateTo);

    Integer getGuarantyState(Integer guarantyId);

    ArrayList<Integer> getGuarantyState(ArrayList<Integer> guarantyIds);
}
