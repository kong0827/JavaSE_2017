package com.hsd.transfer;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class Dao {

	public void out(Account a1, double money,Connection conn) throws SQLException {
		String sql = "update account set money = money - ? where id = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, money,a1.getId());
		
	}

	public void in(Account a2, double money, Connection conn) throws SQLException {
		String sql = "update account set money = money + ? where id = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, money,a2.getId());
		
	}

}
