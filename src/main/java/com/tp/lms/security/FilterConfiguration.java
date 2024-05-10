package com.tp.lms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfiguration {
	
	@Bean
	public FilterRegistrationBean learnFilterRegistration() {

	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(learnFilter());
	    registration.addUrlPatterns("/test/filter");
	    registration.addInitParameter("paramName", "paramValue");
	    registration.setName("learnFilter");
	    registration.setOrder(1);
	    return registration;
	} 
	
	@Bean(name = "learnFilter")
	public Filter learnFilter() {
	    return new LearnFilter();
	}
}
