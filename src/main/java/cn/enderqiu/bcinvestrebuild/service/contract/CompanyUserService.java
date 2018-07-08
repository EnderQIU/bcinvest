package cn.enderqiu.bcinvestrebuild.service.contract;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;

public interface CompanyUserService {
    /**
     * 通过 token 查找企业用户信息
     * @param token 口令
     * @return 企业用户信息对象
     */
    CompanyUserDTO findUserByToken(String token);
}
