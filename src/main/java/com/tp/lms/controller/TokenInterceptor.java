package com.tp.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tp.lms.service.TokenLogService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenLogService tokenLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Extract token from request headers or parameters
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            // Set the response status and custom error message for missing token
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing token");
            return false;
        }

        // Check if the token is valid
        if (tokenLogService.verifyToken(token)) {
            // Token is valid, grant access
            return true;
        } else {
            // Check if the token is expired
            if (tokenLogService.isTokenExpired(token)) {
                // Set the response status and custom error message for expired token
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Expired token");
            } else {
                // Set the response status and custom error message for invalid token
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid token");        
            }
            return false;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // This method is called after the controller method is invoked.
        // You can implement post-processing logic here if needed.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // This method is called after the request has been completed.
        // You can implement cleanup or logging logic here if needed.
    }
}
