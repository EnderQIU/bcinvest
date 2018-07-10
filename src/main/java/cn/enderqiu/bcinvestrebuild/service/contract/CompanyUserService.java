package cn.enderqiu.bcinvestrebuild.service.contract;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;

public interface CompanyUserService {
    /**
     * 通过 token 查找企业用户信息
     * @param token 口令
     * @return 企业用户信息对象
     */
    CompanyUserDTO findUserByToken(String token);
    CompanyUserStatusVO code2InnerToken(String code);

    CompanyUserStatusVO getUserStatus(String token);


    CompanyUserStatusVO saveCompanyData(String token, CompanyUserDTO dto);

    CompanyUserVO getUserData(String token);
}
