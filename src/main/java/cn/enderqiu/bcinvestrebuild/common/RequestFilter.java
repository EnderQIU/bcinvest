package cn.enderqiu.bcinvestrebuild.common;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.service.BankUserService;
import cn.enderqiu.bcinvestrebuild.service.CompanyUserService;
import com.generator.tables.Authorization;
import com.generator.tables.records.AuthorizationRecord;
import org.apache.commons.beanutils.PropertyUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Order(2)
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {
    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private BankUserService bankUserService;

    @Autowired
    private DSLContext dsl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        CompanyUserDTO companyUserDTO = companyUserService.findUserByToken(request.getHeader("user_id_token"));

        AuthorizationRecord record = dsl.fetchOne(Authorization.AUTHORIZATION, Authorization.AUTHORIZATION.TOKEN.eq(request.getHeader("user_id_token")));
        BankUserDTO bankUserDTO = new BankUserDTO();
        if (record != null){
            bankUserDTO.setName(record.getName());
            bankUserDTO.setAccountNum(record.getAccountnum());
            bankUserDTO.setPassword(record.getPassword());
            bankUserDTO.setToken(record.getToken());
            bankUserDTO.setUserType(record.getType());
        }

        RequestUserWrapper requestUserWrapper = new RequestUserWrapper(request);
        requestUserWrapper.setCompanyUserDTO(companyUserDTO);
        requestUserWrapper.setBankUserDTO(bankUserDTO);
        filterChain.doFilter(requestUserWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
