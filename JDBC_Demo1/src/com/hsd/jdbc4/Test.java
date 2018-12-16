package com.hsd.jdbc4;


import java.util.List;



public class Test {
	public static void main(String[] args) {
		String sql = "select * from student";
		DBUtils.getConnection();
		List<Student> list = DBUtils.query(Student.class, sql);
		
		for (Student s : list) {
			System.out.println(s);
		}
	}
}
