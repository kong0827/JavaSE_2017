package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsd.domain.Product;
import com.hsd.service.ProductService;

import net.sf.json.JSONArray;

public class SearchWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		ProductService service = new ProductService();
		List<Object> productList = null;
		try {
			productList = service.findProductListByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(productList);
		
		//使用json的转换工具
		JSONArray fromObject = JSONArray.fromObject(productList);
		String s = fromObject.toString();

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(s);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}