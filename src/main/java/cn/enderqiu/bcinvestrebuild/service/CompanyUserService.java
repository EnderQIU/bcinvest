package cn.enderqiu.bcinvestrebuild.service;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.mapper.CompanyUserMapper;
import cn.enderqiu.bcinvestrebuild.util.CitiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CompanyUserService extends BaseService {

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
        vo = new CompanyUserStatusVO(dto.getStatus(), token);

        return vo;
    }

    private String createNewCompanyUserByOnlyEmail(String onlyEmail) {
        String token = UUID.randomUUID().toString();
        String id = UUID.randomUUID().toString();
        CompanyUserMapper.createUserByTokenAndEmail(id, token, onlyEmail);
        return token;
    }

    private String exchangeOnlyEmail(String accessToken) throws Exception {
        List el = CitiUtil.getCustomerEmail(accessToken);
        return (String) el.get(0);
    }

    private String exchangeAccessToken(String code) throws Exception {
        return CitiUtil.getAccessToken(code);
    }

    public CompanyUserStatusVO getUserStatus(String token) {
        CompanyUserDTO dto = findUserByToken(token);
        String status = dto.getStatus();
        Logger logger = Logger.getLogger("CompanyUserService.class");
        logger.info("Token: " + token + "Status: " + status);

        return new CompanyUserStatusVO(status, token);
    }


    public CompanyUserStatusVO saveCompanyData(String token, CompanyUserDTO dto) {
        if (dto.getUserName() != null)
            CompanyUserMapper.changeUserNameByToken(token, dto.getUserName());
        if (dto.getTelephoneNumber() != null)
            CompanyUserMapper.changeTelNumByToken(token, dto.getTelephoneNumber());
        CompanyUserMapper.changeStatusByToken(token, 1);

        return new CompanyUserStatusVO(dto.getStatus(), token);
    }

    public CompanyUserVO getUserData(String token) {
        CompanyUserDTO dto = new CompanyUserDTO();
        try {
            extract(dto, mapper.SELECT("SELECT AccountNum, Name, TelNum, EmailAddress, Status FROM " + "Company WHERE Token = " + token).get(0));
        }
        catch (Exception e) {
            return null;
        }
        return dto;
    }
}
