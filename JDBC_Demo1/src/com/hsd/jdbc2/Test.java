package com.hsd.jdbc2;

import java.util.List;
import java.util.Map;

import com.hsd.jdbc.Student;

@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
	
		
		DBUtils.getConnection();
		/*String sql = "select * from student";
		
		List<Student> list = DBUtils.query(Student.class,sql);
		
		for (Student student : list) {
			System.out.println(student.getSname()+"\t"+student.getAge());
		}*/
		
		String sql = "insert into student values(?,?,?)";
		int rows = DBUtils.update(sql, 23,"旺a",20);
		if(rows>0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		
		/*sql = "delete from student where sid = ?";
		rows = DBUtils.update(sql, 20);
		if(rows>0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}*/
		DBUtils.close();
		
	}
}
