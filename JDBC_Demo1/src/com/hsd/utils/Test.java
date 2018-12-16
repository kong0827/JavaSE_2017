package com.hsd.utils;

import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
	/*	String sql = "insert into student values(?, ?, ?)";
		DBUtils.getConnection();
		int rows = DBUtils.update(sql, 100,"周杰伦",40);
		if(rows>0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}*/
		
		DBUtils.getConnection();
		String sql = "select * from student";
		List<Map<String,Object>> list = DBUtils.query(sql);
		
			for(Map<String,Object> map : list){
				System.out.println(map);
				for(Map.Entry<String, Object> mapp : map.entrySet()){
					System.out.println(mapp.getKey()+"\t"+mapp.getValue());
				}
			}
		
		DBUtils.close();
		
	}
}
