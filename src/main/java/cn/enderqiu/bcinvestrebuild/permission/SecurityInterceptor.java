package cn.enderqiu.bcinvestrebuild.permission;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.service.contract.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private CompanyUserService companyUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证权限
        if (this.hasPermission(handler, request)) {
            return true;
        }
        response.sendError(HttpStatus.FORBIDDEN.value(), "Permission denied");
        return false;
    }

    /**
     * 是否有权限
     *
     * @param handler
     * @return
     */
    private boolean hasPermission(Object handler, HttpServletRequest request) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            RequiredPermissions requiredPermission = handlerMethod.getMethod().getAnnotation(RequiredPermissions.class);
            // 如果方法上的注解为空 则获取类的注解
            if (requiredPermission == null) {
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredPermissions.class);
            }
            // 如果标记了注解，则判断权限
            if (requiredPermission != null && !StringUtils.isEmpty(requiredPermission.value())) {
                // 数据库中获取该用户的权限信息 并判断是否有权限
                CompanyUserDTO companyUserDTO = (CompanyUserDTO) request.getAttribute("companyUserDTO");
                BankUserDTO bankUserDTO = (BankUserDTO) request.getAttribute("bankUserDTO");
                if (companyUserDTO != null){
                    return requiredPermission.value().contains("company");
                }else if (bankUserDTO != null){
                    String userType = bankUserDTO.getUserType();
                    return requiredPermission.value().contains(userType);
                }
                return false;
            }
        }
        return true;
    }
}
