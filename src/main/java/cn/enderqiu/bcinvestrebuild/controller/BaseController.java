package cn.enderqiu.bcinvestrebuild.controller;

import cn.enderqiu.bcinvestrebuild.common.RequestUserWrapper;
import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected CompanyUserDTO getCompanyUserDTO(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        RequestUserWrapper request = (RequestUserWrapper) servletRequestAttributes.getRequest();
        return request.getCompanyUserDTO();
    }

    protected BankUserDTO getBankUserDTO(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        RequestUserWrapper request = (RequestUserWrapper) servletRequestAttributes.getRequest();
        return request.getBankUserDTO();
    }
}
