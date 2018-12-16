package com.hsd.cookie.encoding;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "ÕÅÈý";
		//String name = "zhangsan";
		name = URLEncoder.encode(name,"utf-8");
		Cookie cookie = new Cookie("uname",name);
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie coo : cookies){
				if(coo.getName().equals("uname")){
					System.out.println(URLDecoder.decode(coo.getValue(), "utf-8"));
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}