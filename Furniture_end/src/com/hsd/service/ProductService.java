package com.hsd.service;

import java.sql.SQLException;
import java.util.List;

import com.hsd.dao.ProductDao;
import com.hsd.domain.Category;
import com.hsd.domain.ConCategory;
import com.hsd.domain.Order;
import com.hsd.domain.PageBean;
import com.hsd.domain.Product;
import com.hsd.domain.Style;
import com.hsd.utils.DataSourceUtils;

public class ProductService {

	//主打产品
	public List<Product> findFeaturedShop() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findFeaturedShop();
		
	}
	
	//热销产品
	public List<Product> findHotProduct() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findHotProduct();
		
	}
	//特价产品
	public List<Product> findSpecialProduct()  throws SQLException{
		ProductDao dao = new ProductDao();
		return dao.findSpecialProduct();
	}

	public PageBean  findPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao dao = new ProductDao();
		PageBean pageBean = new PageBean();
		//1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//3、总条数private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
	
		int index = (currentPage-1)*currentCount;
		
		List<Product> productList = dao.findPageBean(index,currentCount);
		pageBean.setProductList(productList);
		
		return pageBean;
	}

	//单个商品信息
	public Product findSingleProduct(String pid) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findSingleProduct(pid);
	}

	//分类信息显示
	public List<Category> findCategoryList()  throws SQLException{
		ProductDao dao = new ProductDao();
		return dao.findCategoryList();
	}

	public List<Style> findStyleList() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findStyleList();
	}

	//寻找具体分类
	public List<ConCategory> findConCategory(String cid)throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findConCategory(cid);
		
	}

	//根据关键词查找指定商品
	public List<Object> findPnameByWord(String word) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findPnameByWord(word);
		
	}

	public List<Product> searchProduct(String word, String style) throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.searchProduct(word,style);
	}

	public List<Product> findWeekProduct() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findWeekProduct();
	}

	public PageBean findHighPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao dao = new ProductDao();
		PageBean pageBean = new PageBean();
		//1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//3、总条数private int totalCount;
		int totalCount = dao.getHighTotalCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
	
		int index = (currentPage-1)*currentCount;
		
		List<Product> productList = dao.findHighPageBean(index,currentCount);
		pageBean.setProductList(productList);
		
		return pageBean;
	}

	public void submitOrder(Order order) {
ProductDao dao = new ProductDao();
		
		try {
			//1、开启事务
			DataSourceUtils.startTransaction();
			//2、调用dao存储order表数据的方法
			dao.addOrders(order);
			//3、调用dao存储orderitem表数据的方法
			dao.addOrderItem(order);
			
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateOrderAdrr(Order order) {
		ProductDao dao = new ProductDao();
		try {
			dao.updateOrderAdrr(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateOrderState(String r6_Order) {
		ProductDao dao = new ProductDao();
		try {
			dao.updateOrderState(r6_Order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
