package com.hsd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import com.hsd.domain.Category;
import com.hsd.domain.Product;
import com.hsd.service.AdminProductListService;
import com.hsd.vo.Condition;

public class AdminSearchProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1、获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//3、将数据传递到service层
		AdminProductListService service = new AdminProductListService();
		List<Product> productList = null;
		try {
			 productList  = service.findProductListByCondition(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("condition", condition);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
