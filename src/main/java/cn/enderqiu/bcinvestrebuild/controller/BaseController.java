package cn.enderqiu.bcinvestrebuild.controller;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected CompanyUserDTO getCompanyUserDTO(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return (CompanyUserDTO) request.getAttribute("companyUserDTO");
    }

    protected BankUserDTO getBankUserDTO(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return (BankUserDTO) request.getAttribute("bankUserDTO");
    }
}
