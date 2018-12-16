package com.hsd.service.impl;

import java.util.List;

import com.hsd.dao.StudentDao;
import com.hsd.dao.impl.StudentDaoImpl;
import com.hsd.domain.Student;
import com.hsd.service.StudentService;
import com.hsd.utils.BeanFactory;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao = (StudentDao) BeanFactory.getBean("stu_dao");
	
	@Override
	public List<Student> findAllStudent() {
		
		return dao.findAllStudent();
	}

	@Override
	public boolean delStudent(int id) {
		// TODO Auto-generated method stub
		return dao.delStudent(id);
	}

	@Override
	public boolean addStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.addStudent(s);
	}

	@Override
	public Student isExitStudent(int id) {
		// TODO Auto-generated method stub
		return dao.isExitStudent(id);
	}

	@Override
	public boolean updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return dao.updateStudent(stu);
	}

}
