package cn.enderqiu.bcinvestrebuild.common;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * com.hw.myp2c.common.filter
 * Administrator
 * 2017/10/18
 **/
public class RequestUserWrapper extends HttpServletRequestWrapper {

    private CompanyUserDTO companyUserDTO = null;

    private BankUserDTO bankUserDTO = null;

    public RequestUserWrapper(HttpServletRequest request) {
        super(request);
    }


    public CompanyUserDTO getCompanyUserDTO() {
        return companyUserDTO;
    }

    public void setCompanyUserDTO(CompanyUserDTO companyUserDTO) {
        this.companyUserDTO = companyUserDTO;
    }

    public BankUserDTO getBankUserDTO() {
        return bankUserDTO;
    }

    public void setBankUserDTO(BankUserDTO bankUserDTO) {
        this.bankUserDTO = bankUserDTO;
    }
}