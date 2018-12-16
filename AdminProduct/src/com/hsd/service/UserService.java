package com.hsd.service;

import java.sql.SQLException;

import com.hsd.dao.UserDao;
import com.hsd.domain.User;

public class UserService {

	public boolean checkUsername(String username) throws SQLException {
		UserDao dao = new UserDao();
		Long isExit = dao.checkUsername(username);
		
		return isExit>0?true:false;
	}

	public User user_isExit(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.user_isExit(username,password);
	}

}
