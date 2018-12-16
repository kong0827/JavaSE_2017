package com.hsd.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hsd.domain.User;
import com.hsd.utils.DataSourceUtils;

public class UserDao {

	public User findUser(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ?";
		User user = runner.query(sql, new BeanHandler<>(User.class), username);
		return user;
	}

	public boolean regist(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?)";
		int rows = runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),
				user.getTelephone(),user.getCode());
		return rows>0?true:false;
		/**
		 * private String uid;
		private String username;
		private String password;
		private String email;
		private String telephone;
		private String code;
		 */
		
	}

	public boolean userIsExit(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username =? and password = ?";
		User user = runner.query(sql, new BeanHandler<>(User.class), username,password);
		if(user!=null) return true;
		return false;
	}

}
