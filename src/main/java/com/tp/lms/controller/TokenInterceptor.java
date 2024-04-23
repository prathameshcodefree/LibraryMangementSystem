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

		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty()) {

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Missing token");
			return false;
		}

	
		if (tokenLogService.verifyToken(token)) {
			
			return true;
		} else {
			
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
		// This method is called after the controller method is invoked.
		// You can implement post-processing logic here if needed.
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// This method is called after the request has been completed.
		// You can implement cleanup or logging logic here if needed.
	}
}
