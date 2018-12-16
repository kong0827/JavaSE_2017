package com.hsd.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			conn =  DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public static int update(String sql, Object ...paraments){
		
		int rows = 0;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			for(int i=1; i<=paraments.length; i++){
				pst.setObject(i, paraments[i-1]);
			}
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;

	}
	
	public static List<Student> query(String sql, Object ...paraments){
		List<Student> list = new ArrayList<Student>();
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			for(int i=1; i<=paraments.length; i++){
				pst.setObject(i, paraments[i-1]);
			}
			ResultSet rs = pst.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			@SuppressWarnings("unused")
			int columns = metaData.getColumnCount();
			
			/*	while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2));
			}*/
			
			
			
			while(rs.next()){
				
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setAge(rs.getInt(3));
				list.add(student);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static void close(){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
