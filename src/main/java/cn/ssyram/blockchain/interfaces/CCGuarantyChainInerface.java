package cn.ssyram.blockchain.interfaces;

import java.util.List;
import java.util.Map;

public interface CCGuarantyChainInerface extends GuarantyChain  {
    /**
     * 将抵押物上链
     * @param guarantyId 抵押物唯一标识符
     * @return 受影响的结果量
     */
    int insertGuaranty(int guarantyId);

    /**
     * 将抵押物上链
     * @param guarantyId 抵押物唯一标识符
     * @return 受影响的结果量
     */
    int deleteGuaranty(int guarantyId);
    /**
     * 企业获得他拥有的相应状态的所有抵押物
     * @param accountNum 请求用户的唯一标识符
     * @param state 请求的相应状态
     * @return 一个map列表 map<'guarantyId',对应值>
     *   "state": 状态
     *      可抵押（已上链）：onBC（4）
     *      申请抵押中（审核中）：applying（5）
     *      申请已通过（抵押中）：mortgaging（6）
     *      申请还款中：repaying（7）
     *      逾期：overdue（8）
     */
    List<Map<String, Object>> queryGuarantyIdByCompany(String accountNum,int state);

    /**
     * 银行获得相应状态的所有抵押物
     * @param state 请求的相应状态
     * @return 一个map列表 map<'guarantyId',对应值>
     *   "state": 状态
     *      可抵押（已上链）：onBC（4）
     *      申请抵押中（审核中）：applying（5）
     *      申请已通过（抵押中）：mortgaging（6）
     *      申请还款中：repaying（7）
     *      逾期：overdue（8）
     */
    List<Map<String, Object>> queryGuarantyIdByBank(int state);

    /**
     * 变更抵押物状态
     * @param guarantyId 相应抵押物唯一标识符
     * @param state 请求的相应状态
     * @return 受影响的数据量
     */
    int updateState(int guarantyId,int state);
}
