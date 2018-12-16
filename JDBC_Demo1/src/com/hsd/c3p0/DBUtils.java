package com.hsd.c3p0;



import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtils {
	
	//初始化参数

	private static Connection conn ;
	private static PreparedStatement pst ;
	private static ResultSet rs ;
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("igeek");
	
	static{
		dataSource = new ComboPooledDataSource("igeek");
	}
	public static Connection getConnection(){
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return conn;
	}
	
	public static boolean update(String sql, Object ...paraments){
		int rows = 0 ;
		try {
			pst =  conn.prepareStatement(sql);
			
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
	public static <T> List<T> query( @SuppressWarnings("rawtypes") Class clazz, String sql, Object ...paraments){
		//实例化对象
		List<T> list = new ArrayList<T>();
		Object object = null;
		
		
		try {
			conn = DBUtils.getConnection();
			java.sql.PreparedStatement pst =  conn.prepareStatement(sql);
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
 