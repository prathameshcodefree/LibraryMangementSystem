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
        System.out.println("Header 1");
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty()) {
	 
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Missing token");
			return false;
		}
		System.out.println("Header 2");
	
		if (tokenLogService.verifyToken1(token)) {
		System.out.println("Header 3");
	
			return true;
		} 
		
		
		else {
			System.out.println("Header 4");
			if (tokenLogService.isTokenExpired(token)) {

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Expired token");
			} else {

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Invalid token");
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
