package com.tp.lms.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {

    @Bean
    public FilterRegistrationBean<TokenFilter> tokenFilterRegistrationBean(TokenFilter tokenFilter) {
        FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tokenFilter);
        registrationBean.addUrlPatterns("/book/*"); 
        registrationBean.setOrder(1); 
        return registrationBean;
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
