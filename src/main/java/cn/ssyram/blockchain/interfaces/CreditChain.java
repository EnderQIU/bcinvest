package cn.ssyram.blockchain.interfaces;

import cn.ssyram.blockchain.impls.CreditChainImpl;

import java.util.List;
import java.util.Map;

public interface CreditChain extends BlockChain {
    CreditChain chain = new CreditChainImpl();

    /**
     * 更新指定企业的信用
     * @param accountNum
     * @param previousCredit
     * @param delta
     */
    void updateGuarantyState(String accountNum, Integer previousCredit, Integer delta, String timestamp, String reason);

    /**
     * 获取指定企业的信用值
     * @param accountNum
     * @return
     */
    Integer getCreditOfCompany(String accountNum);

    /**
     * 获取指定企业的信用值变化列表
     * @return Map内容：
     *     "id": 企业id
     *     "value": 当时信用值
     *     "variation": 信用值变化
     *     "remarks": ”时间-事件“ 的组合字符串
     *     //remarks记得加s！
     */
    List<Map<String, Object>> getCompanyCreditList(String accountNum);
}