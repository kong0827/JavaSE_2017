package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsd.domain.User;
import com.hsd.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		HttpSession session = request.getSession();
		
		UserService service  = new UserService();
		User user = null;
		try {
			 user = service.user_isExit(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user!=null) {
			if(autoLogin!=null) {
				Cookie cookie_username = new Cookie("cookie_username", username);
				Cookie cookie_password = new Cookie("cookie_password", password);
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("erroMessage", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
