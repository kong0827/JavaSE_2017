package com.hsd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hsd.domain.User;
import com.hsd.service.UserService;

public class UserServlet extends BaseServlet {
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remeber = request.getParameter("remeber");
		
		//System.out.println(username+" "+password+" "+remeber );
		UserService service = new UserService();
		boolean userIsExit= false;
		try {
			userIsExit =  service.userIsExit(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		
		//当用户存在时，才往session域中存数据
		if(userIsExit==true){
			
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("remeber", remeber);
			user.setUsername(username);
			user.setPassword(password);
			session.setAttribute("user", user );
			
			
			//用户名，密码正确且记住密码时，存储信息到session中
			//设置session持久化时间
			Cookie cookie = new Cookie("JSESSIONID",session.getId());
			cookie.setPath(request.getContextPath());
			cookie.setMaxAge(60*10);
			response.addCookie(cookie);
						
			response.sendRedirect(request.getContextPath()+"/product?method=index");
	
		}
		if(userIsExit==false){
			//用户名，或密码错误时，返回错误信息，用request域存储信息，
			//如存到session域中，每次访问login.jsp都会出现错误提示
			request.setAttribute("msg", "用户名或密码错误");
			/*response.sendRedirect(request.getContextPath()+"/login.jsp");*/
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}

	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
			String code = UUID.randomUUID().toString();
			user.setUid(code);
			
			user.setCode(code);
			user.setTelephone("0");
			UserService service = new UserService();
			boolean isSuccess = service.regist(user);
			if(isSuccess){
				response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}