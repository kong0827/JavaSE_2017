package com.igeek.jdbc;

import java.sql.Connection;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TransactionDemo2 {

	Connection conn = null;
	QueryRunner runner = new QueryRunner();

	@Test
	public void demo2() {

		try {
			conn = DataSourceUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "update account set money = money+? where name = ?";

			runner.update(conn, sql, -100, "jack");

			// �����쳣
			int i = 10 / 0;
			runner.update(conn, sql, 100, "rose");

			conn.commit();
			System.out.println("ת�˳ɹ�");
		} catch (SQLException e) {
			try {
				System.out.println("ת��ʧ��");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
