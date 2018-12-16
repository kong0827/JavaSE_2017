package com.igeek.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TransactionDemo1 {

	Connection conn = null;
	PreparedStatement pst = null;

	@Test
	public void demo1() {
		try {
			Connection conn = DataSourceUtils.getConnection();
			conn.setAutoCommit(false);

			String sql = "update account set money = money+? where name = ?";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, -100);
			pst.setString(2, "jack");
			int rows1 = pst.executeUpdate();
			
			//出现异常
			int i = 10/0;
			
			pst.setInt(1, 100);
			pst.setString(2, "rose");
			int rows2 = pst.executeUpdate();
			
			conn.commit();
			System.out.println("转账成功");
		} catch (Exception e) {
			try {
				System.out.println("转账失败");
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				//释放资源
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
