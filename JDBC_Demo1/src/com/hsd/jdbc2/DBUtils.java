package com.hsd.jdbc2;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.jdbc.PreparedStatement;

public class DBUtils {
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;

	public static void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///school";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static int update(String sql, Object... paraments) {

		int rows = 0;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 1; i <= paraments.length; i++) {
				pst.setObject(i, paraments[i - 1]);
			}
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;

	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> query(@SuppressWarnings("rawtypes") Class clazz, String sql, Object... paraments) {
		List<T> list = new ArrayList<T>();
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 1; i <= paraments.length; i++) {
				pst.setObject(i, paraments[i - 1]);
			}
			ResultSet rs = pst.executeQuery();

			//获取列的有关信息
			ResultSetMetaData metaData = rs.getMetaData();

			int columns = metaData.getColumnCount();

			while (rs.next()) {
				Object obj = clazz.newInstance();
				for(int i=1; i<=columns; i++){
					BeanUtils.setProperty(obj, metaData.getColumnName(i), rs.getObject(i));
				}
				list.add((T) obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return list;

	}

	public static void close() {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
