package com.hsd.dao;

import java.util.List;

import com.hsd.domain.Student;



public interface StudentDao {

	public List<Student> findAllStudent();
	
	public boolean delStudent(int id);
	
	public boolean addStudent(Student s);
	
	public Student isExitStudent(int id);
	
	public boolean updateStudent(Student stu);
}
