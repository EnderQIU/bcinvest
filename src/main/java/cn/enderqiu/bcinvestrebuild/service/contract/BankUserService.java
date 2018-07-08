package cn.enderqiu.bcinvestrebuild.service.contract;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;

public interface BankUserService {
    /**
     * 通过 token 获取银行用户信息
     * @param token 口令
     * @return 银行用户信息对象
     */
    BankUserDTO findUserByToken(String token);
}
