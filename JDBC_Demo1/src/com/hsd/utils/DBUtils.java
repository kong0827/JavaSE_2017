package com.hsd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static List<Map<String,Object>> query(String sql, Object ...paraments){
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			for(int i=1; i<=paraments.length; i++){
				pst.setObject(i, paraments[i-1]);
			}
			ResultSet rs = pst.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			
			/*	while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2));
			}*/
			
			//光标下移
			while(rs.next()){
				//Map<String,Object> map = new HashMap();必须放在while体内，这样每次光标下移一次，new出一个新的map
				//否则放在while体外，每次则会出现key值覆盖，只会存进去最后一行数据，放在体内，每次new出新的map则会在加入数据后加入list中
				//再new新对象就是一个全新的map
				Map<String,Object> map = new HashMap<String, Object>();
				
				//依次读取一行中每列的数据
				for(int i=1; i<=columns; i++){
					//System.out.println(metaData.getColumnName(i)+"\t"+ rs.getObject(i));
					map.put(metaData.getColumnName(i), rs.getObject(i));
					//System.out.println(metaData.getColumnName(i).hashCode());
				}
				list.add(map);
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
