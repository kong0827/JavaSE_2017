package com.hsd.transfer;

import java.sql.Connection;
import java.sql.SQLException;

public class Service {

	Dao dao = new Dao();
	
	
	public boolean transfer(Account a1, Account a2) {
		boolean flag = false;
		try {
			Connection conn = DataSourceUtils.getConnection();
			DataSourceUtils.startTransaction();
			double money = 100.02;
			dao.out(a1,money,conn);
			dao.in(a2,money,conn);
			flag = true;
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}

	

}
