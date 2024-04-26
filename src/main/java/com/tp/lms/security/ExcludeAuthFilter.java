package com.tp.lms.security;


import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class ExcludeAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the request URI
        String requestURI = ((HttpServletRequest) request).getRequestURI();

        // Check if the request is for /auth endpoints
        if (requestURI.startsWith("/auth/")) {
            // If it is, skip the filter and proceed to the next one
            chain.doFilter(request, response);
        } else {
            // Otherwise, continue with the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }

	
}
