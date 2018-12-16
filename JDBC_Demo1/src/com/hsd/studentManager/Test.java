package com.hsd.studentManager;


import java.util.List;

import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;


public class Test {

	static Scanner sc = new Scanner(System.in);
	static QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

	public static void main(String[] args)  {

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
				StudentDao dao = new StudentDao();
				List<Student> studentList = dao.findAllStudent();
				for (Student student : studentList) {
					System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getAge());
				}
				System.out.println();
				break;
			case 2:
				System.out.println("请输入要删除学生编号：");
				int id = sc.nextInt();
				boolean isSuccess = new StudentDao().delStudent(id);
				if (isSuccess) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败");
				}
				System.out.println();
				break;
			case 3:
				System.out.println("请输入学生编号");
				int sid = sc.nextInt();
				System.out.println("请输入学生姓名");
				String name = sc.next();
				System.out.println("请输入学生年龄");
				int age = sc.nextInt();
				Student s = new Student();
				s.setSid(sid);
				s.setSname(name);
				s.setAge(age);
				boolean addStudent = new StudentDao().addStudent(s);
				if (addStudent) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}

				break;
			case 4:
				System.out.println("请输入修改的学号");
				id = sc.nextInt();
				Student student = new StudentDao().isExitStudent(id);

				if (student != null) {
					System.out.println("该学生信息为：");
					System.out.println("学号：" + "\t" + "姓名" + "\t" + "年龄");
					System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getAge());
					System.out.println("请输入修改的姓名");
					String sname = sc.next();
					System.out.println("请输入学生的年龄");
					int sage = sc.nextInt();
					Student stu = new Student();
					stu.setSid(id);
					stu.setSname(sname);
					stu.setAge(sage);
					boolean updateStudent = new StudentDao().updateStudent(stu);

					if (updateStudent) {
						System.out.println("修改成功");
					} else {
						System.out.println("修改失败");
					}
				} else {
					System.out.println("没有该学生");
					
				}
				break;
			case 5:
				flag = true;
				break;

			default:
				System.out.println("你的输入有误，请重新输入");
				break;
			}

			//case5跳出循环
			if (flag)
				break;
		}

		System.out.println("退出系统成功");
	}

}
