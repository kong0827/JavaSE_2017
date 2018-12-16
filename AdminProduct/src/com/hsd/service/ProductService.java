package com.hsd.service;

import java.sql.SQLException;
import java.util.List;

import com.hsd.dao.ProductDao;
import com.hsd.domain.Product;
import com.hsd.vo.PageBean;

public class ProductService {
	/*
	 * ��ǰҳ private int currentPage; ��ǰҳ��ʾ������ private int currentCount; ������
	 * private int totalCount; ��ҳ�� private int totalPage; ÿҳ��ʾ������ private
	 * List<T> productList = new ArrayList<>();
	 */

	public PageBean findAllProduct(int currentPage, int currentCount) throws SQLException {
		ProductDao dao = new ProductDao();
		PageBean<Product> pageBean = new PageBean();
		// 1����ǰҳ
		pageBean.setCurrentPage(currentPage);
		// 2����ǰ��ʾ������
		pageBean.setCurrentCount(currentCount);
		// 3��������
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		// 4����ҳ��
		int totalPage = (int) Math.ceil(1.0 * totalCount / currentCount);
		pageBean.setTotalPage(totalPage);
		// 5��ÿҳ��ʾ������
		/*
		 * ҳ����limit��ʼ�����Ĺ�ϵ ���� ÿҳ��ʾ4�� ҳ�� ��ʼ���� ÿҳ��ʾ���� 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * ����index = (��ǰҳ��-1)*ÿҳ��ʾ������
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
		// ��װpageBean����
		ProductDao dao = new ProductDao();
		PageBean<Product> pageBean = new PageBean();
		pageBean.setCurrentCount(currentCount);
		pageBean.setCurrentPage(currentPage);
		int totalCount = 0;
		List<Product> productList = null;
		// ��ҳ��
		

		// ��ǰ����
		int index = (currentPage - 1) * currentCount;

		// ������
		totalCount = dao.getTotalCountByCid(cid);
		// ��Ʒ�б�
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
