package cn.ssyram.blockchain.interfaces;

import java.util.List;
import java.util.Map;

public interface zyCreditChainInterface extends GuarantyChain {
    /**
     *
     * @param accountNum 公司的Id编号值
     * @return 返回公司的信用分数
     */
   List<Map<String,Object>> queryCompanyCredit(String accountNum);
}
