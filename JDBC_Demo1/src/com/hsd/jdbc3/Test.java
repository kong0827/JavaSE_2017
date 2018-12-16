package com.hsd.jdbc3;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		String sql = "select * from stu";
		DBUtils.getConnection();
		List<Stu> list = DBUtils.query(Stu.class, sql);
		
		for (Stu s : list) {
			Date date = s.getBirthday();
			SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			String birthday = format.format(date);
			
			System.out.println(birthday);
		}
	}

}
