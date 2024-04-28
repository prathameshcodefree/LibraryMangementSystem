package com.tp.lms.security;


import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LearnFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    	boolean started = true;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // This method is invoked for each request passing through the filter

        // Place your filtering logic here

        // For example, you can modify request/response parameters, headers, etc.

        // Continue the request chain
    	
    	System.out.println("Hi team, i run before controller get executed");
        
        chain.doFilter(request, response);
        

    	System.out.println("Hi team, i run after controller get executed");
    }

	/*
	 * @Override public void destroy() { started = false; }
	 */
}