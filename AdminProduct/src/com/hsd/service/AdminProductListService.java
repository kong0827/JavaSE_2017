package com.hsd.service;

import java.sql.SQLException;
import java.util.List;

import com.hsd.dao.AdminProductListDao;
import com.hsd.domain.Category;
import com.hsd.domain.Product;
import com.hsd.vo.Condition;

public class AdminProductListService {

	public List<Product> findAllProductList() throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		List<Product> productList = dao.findAllProductList();
		return productList;
	}

	public List<Category> findAllCategory() throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		List<Category> categoryList = dao.findAllCategory();
		return categoryList;
	}

	public void addProduct(Product product) throws SQLException {
		AdminProductListDao dao = new  AdminProductListDao();
		dao.addProduct(product);
		
	}

	public void delProductByPid(String pid) throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		dao.delProductByPid(pid);
		
	}

	public Product findProductByPid(String pid) throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		Product product = dao.findProductByPid(pid);
		return product;
	}

	public void updateProduct(Product product) throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		dao.updateProduct(product);
		
	}

	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		AdminProductListDao dao = new AdminProductListDao();
		return dao.findProductListByCondition(condition);
		
	}

}
