package com.hsd.service;

import java.sql.SQLException;
import java.util.List;

import com.hsd.dao.CategoryDao;
import com.hsd.domain.Category;

public class CategoryService {

	public List<Category> findAllCategoryList() throws SQLException {
		CategoryDao dao = new CategoryDao();
		return dao.findAllCategoryList();
		
		
	}

}
