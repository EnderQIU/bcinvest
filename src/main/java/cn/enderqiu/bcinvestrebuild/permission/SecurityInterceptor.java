package cn.enderqiu.bcinvestrebuild.permission;

import cn.enderqiu.bcinvestrebuild.filter.RequestUserWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor implements HandlerInterceptor {

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
     * @param request
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

                if (((RequestUserWrapper) request).getCompanyRecord() != null){
                    return requiredPermission.value().contains("company");
                }else if (((RequestUserWrapper) request).getBankoperatorRecord() != null){
                    return requiredPermission.value().contains("bank");
                }else if(((RequestUserWrapper) request).getAuthorityRecord() != null){
                    return requiredPermission.value().contains("authority");
                }
                return false;
            }
        }
        return true;
    }
}
