package cn.enderqiu.bcinvestrebuild.common;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.service.contract.BankUserService;
import cn.enderqiu.bcinvestrebuild.service.contract.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {
    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private BankUserService bankUserService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        CompanyUserDTO companyUserDTO = companyUserService.findUserByToken(request.getHeader("Authorization"));
        BankUserDTO bankUserDTO = bankUserService.findUserByToken(request.getHeader("Authorization"));
        RequestUserWrapper requestUserWrapper = new RequestUserWrapper(request);
        requestUserWrapper.setCompanyUserDTO(companyUserDTO);
        requestUserWrapper.setBankUserDTO(bankUserDTO);
        filterChain.doFilter(requestUserWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
