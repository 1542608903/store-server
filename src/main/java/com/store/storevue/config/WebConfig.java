package com.store.storevue.config;

import com.store.storevue.Interceptor.LogniInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void  addInterceptors( InterceptorRegistry registry){
        registry.addInterceptor(new LogniInterceptor()).addPathPatterns("./user/**");
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/Project/store/src/main/resources/images/");
    }
}
