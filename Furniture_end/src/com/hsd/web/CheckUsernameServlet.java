package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsd.domain.User;
import com.hsd.service.UserService;

public class CheckUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String username = request.getParameter("username");
		UserService service = new UserService();
		User user = null;
		try {
			user = service.findUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isExist = false;
		if(user!=null){
			isExist = true;
		}
		String json = "{\"isExist\":"+isExist+"}";
		
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
