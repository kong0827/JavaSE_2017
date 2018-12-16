package com.hsd.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsd.domain.User;
import com.hsd.service.UserService;

public class AutoLoginFilter implements Filter{


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String username = null;
		String password = null;
		
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cookie_username")) {
					username = cookie.getValue();
				}
				if(cookie.getName().equals("cookie_password")) {
					password = cookie.getValue();
				}
			}
		}
		
	
		
		if(username!=null&&password!=null){
			
			UserService service  = new UserService();
			User user = null;
			try {
				 user = service.user_isExit(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将登录的用户的user对象存到session中
			session.setAttribute("user", user);
			
		}
		
		chain.doFilter(request, response);
	}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}


	public void destroy() {
		
	}

}
