package com.hsd.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hsd.domain.Category;
import com.hsd.utils.DataSourceUtils;

public class CategoryDao {

	public List<Category> findAllCategoryList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));
		return categoryList;
	}

}
