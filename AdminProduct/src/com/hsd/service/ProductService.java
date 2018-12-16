package com.hsd.service;

import java.sql.SQLException;
import java.util.List;

import com.hsd.dao.ProductDao;
import com.hsd.domain.Product;
import com.hsd.vo.PageBean;

public class ProductService {
	/*
	 * 当前页 private int currentPage; 当前页显示的条数 private int currentCount; 总条数
	 * private int totalCount; 总页数 private int totalPage; 每页显示的数据 private
	 * List<T> productList = new ArrayList<>();
	 */

	public PageBean findAllProduct(int currentPage, int currentCount) throws SQLException {
		ProductDao dao = new ProductDao();
		PageBean<Product> pageBean = new PageBean();
		// 1、当前页
		pageBean.setCurrentPage(currentPage);
		// 2、当前显示的条数
		pageBean.setCurrentCount(currentCount);
		// 3、总条数
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		// 4、总页数
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 起始索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;
		List<Product> productList = dao.getProductList(index, currentCount);
		pageBean.setProductList(productList);

		return pageBean;
	}

	public List<Object> findProductListByWord(String word) throws SQLException {
		ProductDao dao = new ProductDao();
		List<Object> productList = dao.findProductListByWord(word);
		return productList;
	}

	public PageBean findProductListByCid(String cid, int currentPage, int currentCount) throws SQLException {
		// 封装pageBean对象
		ProductDao dao = new ProductDao();
		PageBean<Product> pageBean = new PageBean();
		pageBean.setCurrentCount(currentCount);
		pageBean.setCurrentPage(currentPage);
		int totalCount = 0;
		List<Product> productList = null;
		// 总页数
		

		// 当前索引
		int index = (currentPage - 1) * currentCount;

		// 总条数
		totalCount = dao.getTotalCountByCid(cid);
		// 商品列表
		productList = dao.findProductListByCid(cid, index, currentCount);
		
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		
		pageBean.setTotalCount(totalCount);
		pageBean.setProductList(productList);

		return pageBean;
	}

	public Product findProductByPid(String pid) throws SQLException {
		ProductDao dao = new ProductDao();
		Product product = dao.findProductByPid(pid);
		return product;
		
	}

}
