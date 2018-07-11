package cn.enderqiu.bcinvestrebuild.service;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.mapper.CompanyUserMapper;
import cn.enderqiu.bcinvestrebuild.util.CitiUtil;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CompanyUserService extends BaseService{

    @Autowired
    private CompanyUserMapper CompanyUserMapper;

    public CompanyUserDTO findUserByToken(String token) {
        return CompanyUserMapper.findUserByToken(token);
    }

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
            token = CompanyUserMapper.findTokenByOnlyEmail(onlyEmail).getToken();
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
        CompanyUserMapper.createUserByTokenAndEmail(token, onlyEmail);
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

    public CompanyUserStatusVO getUserStatus(String token) {
        CompanyUserDTO dto = findUserByToken(token);
        String status = statusToString(dto.getStatus());

        return new CompanyUserStatusVO(status, token);
    }


    public CompanyUserStatusVO saveCompanyData(String token, CompanyUserDTO dto) {
        if (dto.getUserName() != null)
            CompanyUserMapper.changeUserNameByToken(token, dto.getUserName());
        if (dto.getTelephoneNumber() != null)
            CompanyUserMapper.changeTeleNumByToken(token, dto.getTelephoneNumber());
        CompanyUserMapper.changeStatusByToken(token, 1);

        return new CompanyUserStatusVO(statusToString(dto.getStatus()), token);
    }

    public CompanyUserVO getUserData(String token) {
        return findUserByToken(token);
    }
}