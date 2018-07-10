package cn.enderqiu.bcinvestrebuild.service.impl;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.mapper.CompanyUserMapper;
import cn.enderqiu.bcinvestrebuild.service.contract.CompanyUserService;
import cn.enderqiu.bcinvestrebuild.util.CitiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyUserServiceImpl implements CompanyUserService {

    @Autowired
    private CompanyUserMapper mapper;

    @Override
    public CompanyUserDTO findUserByToken(String token) {
        return mapper.findUserByToken(token);
    }


    @Override
    public CompanyUserStatusVO code2InnerToken(String code) {
        CompanyUserStatusVO vo;
        String accessToken;
        String onlyEmail;
        try {
            accessToken = exchangeAccessToken(code);
            onlyEmail = exchangeOnlyEmail(accessToken);
        }catch (Exception e){
            vo = new CompanyUserStatusVO("process_failed", null);
            return vo;
        }

        String token;
        try {
            token = mapper.findTokenByOnlyEmail(onlyEmail).getToken();
        }
        catch (Exception e) {
            token = createNewCompanyUserByOnlyEmail(onlyEmail);
        }
        CompanyUserDTO dto = findUserByToken(token);
        vo = new CompanyUserStatusVO(statusToString(dto.getStatus()), token);

        return vo;
    }

    private String createNewCompanyUserByOnlyEmail(String onlyEmail) {
        String token = UUID.randomUUID().toString();
        mapper.createUserByTokenAndEmail(token, onlyEmail);
        return token;
    }

    private String exchangeOnlyEmail(String accessToken) throws Exception {
        List el = CitiUtil.getCustomerEmail(accessToken);
        return (String) el.get(0);
    }

    private String exchangeAccessToken(String code) throws Exception {
        return CitiUtil.getAccessToken(code);
    }

    private String statusToString(int status) {
        switch (status){
            case 0:
                return "unapplied";
            case 1:
                return "checking";
            case 2:
                return "unpassed";
            case 3:
                return "passed";
        }
        return "process_failed";
    }

    @Override
    public CompanyUserStatusVO getUserStatus(String token) {
        CompanyUserDTO dto = findUserByToken(token);
        String status = statusToString(dto.getStatus());

        return new CompanyUserStatusVO(status, token);
    }

    @Override
    public CompanyUserStatusVO saveCompanyData(String token, CompanyUserDTO dto) {
        if (dto.getUserName() != null)
            mapper.changeUserNameByToken(token, dto.getUserName());
        if (dto.getTelephoneNumber() != null)
            mapper.changeTeleNumByToken(token, dto.getTelephoneNumber());
        mapper.changeStatusByToken(token, 1);

        return new CompanyUserStatusVO(statusToString(dto.getStatus()), token);
    }

    @Override
    public CompanyUserVO getUserData(String token) {
        return findUserByToken(token);
    }
}
