package com.hsd.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hsd.domain.Category;
import com.hsd.service.CategoryService;
import com.hsd.utils.JedisPoolUtils;

import redis.clients.jedis.Jedis;



public class CategoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		List<Category> categorylist = null;
		response.setContentType("text/html;charset=UTF-8");
		
		//先从缓存查
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryJson = jedis.get("categoryJson");
		if(categoryJson==null){
			try {
				System.out.println("从数据库查询");
				categorylist = service.findAllCategoryList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Gson gson = new Gson();
			
			categoryJson = gson.toJson(categorylist);
			jedis.set("categoryJson", categoryJson);
		}
		response.getWriter().write(categoryJson);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}