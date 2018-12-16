package com.hsd.studentManager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CourseDao {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	Scanner sc = new Scanner(System.in);

	public List<Course> findAllCourse(){

		String sql = "select * from course";
		List<Course> courseList = null;
		try {
			courseList = runner.query(sql, new BeanListHandler<>(Course.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(courseList);
		return courseList;

	}

	public boolean delCourse(int id){
		String sql = "delete from  course where cid = ?";
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

	public boolean addCourse(Course c) {
		String sql = "insert into course values(?,?,?)";
		int rows = 0;
		try {
			rows = runner.update(sql, c.getCid(), c.getCname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0) {
			return true;
		}
		return false;

	}

	public Course isExitCourse(int id){

		String sql = "select * from course where cid = ?";
		Course course = null;
		try {
			course = runner.query(sql, new BeanHandler<Course>(Course.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
		
	}

	public boolean updateCourse(Course c) {
		String sql = "update course set cname = ? where cid = " + c.getCid();
		int rows = 0;
		try {
			rows = runner.update(sql,c.getCname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows>0){
			return true;
		}
		return false;
		
	}

}
