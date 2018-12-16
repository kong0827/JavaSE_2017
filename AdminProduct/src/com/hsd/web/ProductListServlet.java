package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsd.domain.Product;
import com.hsd.service.ProductService;
import com.hsd.vo.PageBean;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();
		PageBean<Product> pageBean = null;
		//当前页
		String currentPageStr = request.getParameter("currentPage");
		
		if(currentPageStr==null) currentPageStr = "1";
		 int currentPage = Integer.parseInt(currentPageStr);
		//当前页显示的条数
		int currentCount = 12;
		try {
			pageBean = service.findAllProduct(currentPage,currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}