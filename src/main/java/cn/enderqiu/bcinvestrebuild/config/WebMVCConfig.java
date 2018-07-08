package cn.enderqiu.bcinvestrebuild.config;

import cn.enderqiu.bcinvestrebuild.permission.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMVCConfig extends WebMvcConfigurationSupport {
    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor()).excludePathPatterns("/static/*")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }
}
