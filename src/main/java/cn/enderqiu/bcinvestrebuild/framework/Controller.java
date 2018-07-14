package cn.enderqiu.bcinvestrebuild.framework;

import cn.enderqiu.bcinvestrebuild.filter.RequestUserWrapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Controller {

    protected RequestUserWrapper request;

    /**
     * @return 发起请求的用户
     */
    protected Object getRequestUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        RequestUserWrapper request = (RequestUserWrapper) servletRequestAttributes.getRequest();
        return request.getUserRecord();
    }

    public RequestUserWrapper getRequest() {
        return request;
    }

    public void setRequest(RequestUserWrapper request) {
        this.request = request;
    }
}
