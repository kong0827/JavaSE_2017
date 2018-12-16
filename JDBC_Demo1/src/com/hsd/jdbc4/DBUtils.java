package com.hsd.jdbc4;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.jdbc.PreparedStatement;

public class DBUtils {
	
	//初始化参数
	private static String driverClass;
	private static String url ;
	private static String user ;
	private static String password ;
	private static Connection conn ;
	private static PreparedStatement pst ;
	private static ResultSet rs ;
	
	static{
		try {
			Properties properties = new Properties();
			Student.class.getClassLoader();
			//InputStream is = new FileInputStream("src/config.properties");
			InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
			properties.load(is);
			
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			
			Class.forName(driverClass);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean update(String sql, Object ...paraments){
		int rows = 0 ;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			
			for(int i=0; i<paraments.length; i++){
				pst.setObject(i+1, paraments[i]);
			}
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows>0){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> query(@SuppressWarnings("rawtypes") Class clazz, String sql, Object ...paraments){
		//实例化对象
		List<T> list = new ArrayList<T>();
		Object object = null;
		
		try {
			
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			for(int i=0; i<paraments.length; i++){
				//mysql从 1 开始， java从 0 开始
				pst.setObject(i+1, paraments[i]);
			}
			ResultSet rs = pst.executeQuery();
			
			//获取列的有关信息
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			
			while(rs.next()){
				object = clazz.newInstance();
				for(int i=0; i<columnCount; i++){
					try {
						BeanUtils.setProperty(object, metaData.getColumnName(i+1), rs.getObject(i+1));
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				
				list.add((T) object);
			}
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pst!=null){
			try {
				pst.close();
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
 