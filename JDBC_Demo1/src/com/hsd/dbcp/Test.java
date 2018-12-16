package com.hsd.dbcp;

import java.util.List;

import com.hsd.c3p0.Student;



public class Test {
	public static void main(String[] args) {
		String sql = "select * from student";
		List<Student> list = DBUtils.query(Student.class, sql);
		
		for (Student s : list) {
			System.out.println(s);
		}
		
		sql = "delete from student where sid = ?";
		boolean update = DBUtils.update(sql, 12);
		if(update){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
	}

}
