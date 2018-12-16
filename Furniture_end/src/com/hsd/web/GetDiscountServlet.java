package com.hsd.web;

import java.io.IOException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsd.utils.MailUtils;

public class GetDiscountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		String code = UUID.randomUUID().toString();
		String emailMsg = "点击立即领取优惠券，下一个订单会有10%的折扣"
				+"<a href='http://localhost:8080/Furniture_end/active.jsp?code="+code+"'>"
				+"http://localhost:8080/Furniture_end/active?code="+code+"</a>";
		try {
			MailUtils.sendMail(email, "MyStore优惠券领取", emailMsg);
			response.sendRedirect(request.getContextPath()+"/notShowPopup");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}