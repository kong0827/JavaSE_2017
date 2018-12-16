package com.hsd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

public class NotShowPopupServlet extends HttpServlet {
	
	//不再显示首页弹出框
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Cookie cookie = new Cookie("popup","none");
//			cookie.setMaxAge(10*60);
			response.addCookie(cookie);
		
			
		
			response.sendRedirect(request.getContextPath()+"/default.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}