package org.bunnysugar.config;

import org.bunnysugar.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {  //這邊用來註冊攔截器

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登入接口與註冊接口不攔截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login", "/user/register", "/user/verify");
    }
}
