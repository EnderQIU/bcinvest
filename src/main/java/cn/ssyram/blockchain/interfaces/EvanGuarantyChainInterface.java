package cn.ssyram.blockchain.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Created by EvanChoo on 7/15/18.
 */

public interface EvanGuarantyChainInterface extends GuarantyChain {
    /**
     * 强制某个抵押物下链，添加删除信息到区块链
     * @param guarantyId
     * @return 删除成功返回1，删除失败或者没有这个抵押物返回0
     */
    int deleteGuaranty(int guarantyId);

    /**
     * 查询公司credit
     * @param accountNum
     * @return 公司的信用数
     */
    List<Map<String, Object>> queryCompanyCredit(String accountNum);
}
