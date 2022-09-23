package org.zkh.hotnews.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class InterceptorConfig implements WebMvcConfigurer {
    //@Resource
    //UserTokenInterceptor userTokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //     registry.addInterceptor(userTokenInterceptor)
        //            .addPathPatterns("/*");

    }
}
