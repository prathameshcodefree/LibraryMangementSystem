package com.tp.lms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tp.lms.controller.TokenInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    public WebMvcConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/student/**") 
                .addPathPatterns("/book/**")
                .addPathPatterns("/bookMaster/**")
                .addPathPatterns("/bookcategory/**")
                .addPathPatterns("/booksubcategory/**")
                .addPathPatterns("/bookfine/**")
                .addPathPatterns("/racks/**")
                .addPathPatterns("/requirement/**")
                .addPathPatterns("/staff/**")
                .addPathPatterns("/attendance/**")
                .excludePathPatterns("/auth/**"); 
    }
}
