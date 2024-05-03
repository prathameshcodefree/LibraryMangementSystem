package com.tp.lms.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebMvcConfig1 {

    @Bean
    public FilterRegistrationBean<TokenFilter> tokenFilterRegistrationBean(TokenFilter tokenFilter) {
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tokenFilter);
        registrationBean.addUrlPatterns(
            "/student/*",
            "/book/*",
            "/bookcategory/*",
            "/bookissue",
            "/bookfine/*",
            "/bookMaster/*",
            "/racks/*",
            "/requirement/*",
            "/staff/*",
            "/attendance/*"
        );
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<TokenFilter> authFilterRegistrationBean(TokenFilter tokenFilter) {
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tokenFilter);
        registrationBean.addUrlPatterns("/auth/*");
        registrationBean.setOrder(2);
        registrationBean.setEnabled(false);
        return registrationBean;
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}