package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsd.service.ProductService;
import com.hsd.vo.PageBean;

public class ProductListByCidServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		
		ProductService service = new ProductService();
		
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		int currentCount = 12;
		if(currentPageStr==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		PageBean pageBean = null;
		try {
			pageBean = service.findProductListByCid(cid,currentPage,currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
