package com.hsd.c3p0;

import java.util.List;



public class Test {
	public static void main(String[] args) {
		String sql = "select * from student";
	
		List<Student> list = DBUtils.query(Student.class, sql);
		
		for (Student s : list) {
			System.out.println(s);
		}
		
		
		sql = "update student set sname = ? where sid = ?";
		boolean update = DBUtils.update(sql, "刘强东",23);
		if(update){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
}