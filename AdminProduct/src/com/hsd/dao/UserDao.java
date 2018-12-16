package com.hsd.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hsd.domain.User;
import com.hsd.utils.DataSourceUtils;
 
public class UserDao {

	public Long checkUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where username = ?";
		Long query = (Long)runner.query(sql, new ScalarHandler(), username);
		return query;
	}

	public com.hsd.domain.User user_isExit(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
		return user;
	}
}
