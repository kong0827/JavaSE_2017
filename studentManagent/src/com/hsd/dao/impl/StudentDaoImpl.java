package com.hsd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hsd.dao.StudentDao;
import com.hsd.domain.Student;
import com.hsd.utils.DataSourceUtils;


public class StudentDaoImpl implements StudentDao{

	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	Scanner sc = new Scanner(System.in);

	public List<Student> findAllStudent(){

		String sql = "select * from student";
		List<Student> studentList = null;
		try {
			studentList = runner.query(sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;

	}

	public boolean delStudent(int id){
		String sql = "delete from  student where sid = ?";
		int rows = 0;
		try {
			rows = runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0) {
			return true;
		}
		return false;
	}

	public boolean addStudent(Student s) {
		String sql = "insert into student values(?,?,?)";
		int rows = 0;
		try {
			rows = runner.update(sql, s.getSid(), s.getSname(), s.getAge());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0) {
			return true;
		}
		return false;

	}

	public Student isExitStudent(int id){

		String sql = "select * from student where sid = ?";
		Student student = null;
		try {
			student = runner.query(sql, new BeanHandler<Student>(Student.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
		
	}

	public boolean updateStudent(Student stu) {
		String sql = "update student set sname = ?, age = ? where sid = " + stu.getSid();
		int rows = 0;
		try {
			rows = runner.update(sql,stu.getSname(),stu.getAge());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows>0){
			return true;
		}
		return false;
		
	}

}
