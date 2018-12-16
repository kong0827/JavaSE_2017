package com.hsd.jdbc;

import java.util.List;


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
		/*List<Map<String,Object>> list = DBUtils.query(sql);
		
			for(Map<String,Object> map : list){
				System.out.println(map);
				for(Map.Entry<String, Object> mapp : map.entrySet()){
					System.out.println(mapp.getKey()+"\t"+mapp.getValue());
				}
			}*/
		
		List<Student> list = DBUtils.query(sql);
		for(int i=0; i<list.size(); i++){
			
			System.out.println(list.get(i).getSid()+"\t"+list.get(i).getSname()+"\t"+list.get(i).getAge());
		}
		
		DBUtils.close();
		
	}
}
