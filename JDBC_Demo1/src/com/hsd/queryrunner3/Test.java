package com.hsd.queryrunner3;

import java.sql.SQLException;
import java.util.List;

import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Test {
	
	static Scanner sc = new Scanner(System.in);
	static QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

	public static void main(String[] args) throws SQLException {
		
		while (true) {
			boolean flag = false;
			System.out.println("***********************");
			System.out.println("欢迎登陆学生管理系统");
			System.out.println("1、查看所有学生");
			System.out.println("2、删除学生");
			System.out.println("3、添加学生");
			System.out.println("4、修改学生");
			System.out.println("5、退出");
			System.out.println("***********************");

			System.out.println("请输入你的选择：");
			int choose = sc.nextInt();

			switch (choose) {
			case 1:
				findAllStudent();
				break;
			case 2:
				delStudent();
				break;
			case 3:
				addStudent();
				break;
			case 4:
				editStudent();
				break;
			case 5:
				flag=true;
				break;

			default:
				System.out.println("你的输入有误，请重新输入");
				break;
			}
			
			if(flag)break;
		}
		
		System.out.println("退出系统成功");
	}

	private static  void editStudent() throws SQLException {
		System.out.println("请输入修改的学号");
		int id = sc.nextInt();
		String sql = "select * from student where sid = ?";
		Student student = runner.query(sql, new BeanHandler<Student>(Student.class), id);
		if(student!=null){
			System.out.println("该学生信息为：");
			System.out.println("学号："+"\t"+"姓名"+"\t"+"年龄");
			System.out.println(student.getSid()+"\t"+student.getSname()+"\t"+student.getAge());
			System.out.println("请输入修改的姓名");
			String name = sc.next();
			System.out.println("请输入学生的年龄");
			int age = sc.nextInt();
			sql = "update student set sname = ?, age = ? where sid = "+id;
			int rows = runner.update(sql, name,age);
			if(rows>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		}else{
			System.out.println("没有该学生");
			return ;
		}
	}

	private static void addStudent() throws SQLException {
		//QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		System.out.println("请输入学生编号");
		int id = sc.nextInt();
		System.out.println("请输入学生姓名");
		String name = sc.next();
		System.out.println("请输入学生年龄");
		int age = sc.nextInt();

		String sql = "insert into student values(?,?,?)";
		int rows = runner.update(sql, id, name, age);

		if (rows > 0) {
			System.out.println("添加学生成功");
		} else {
			System.out.println("添加学生失败");
		}

		System.out.println();
	}

	private static void delStudent() throws SQLException {
		System.out.println("请输入学生编号：");
		int id = sc.nextInt();
		//QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from  student where sid = ?";
		int rows = runner.update(sql, id);
		if (rows > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}

		System.out.println();
	}

	private static void findAllStudent() throws SQLException {
		//QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student";
		List<Student> studentList = runner.query(sql, new BeanListHandler<>(Student.class));
		for (Student student : studentList) {
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getAge());
		}
		System.out.println();

	}

}
