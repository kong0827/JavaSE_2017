package com.hsd.service;

import java.sql.SQLException;

import com.hsd.dao.UserDao;
import com.hsd.domain.User;

public class UserService {

	public User findUser(String username) throws SQLException {
		UserDao dao = new UserDao();
		
		return dao.findUser(username);
	}

	public boolean regist(User user) throws SQLException {
		UserDao dao = new UserDao();
		 return dao.regist(user);
	}

	public boolean userIsExit(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.userIsExit(username,password);
	}

}
