package com.hsd.demo1;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class Demo2 {
	
	/**
	 * ����˽�й��췽��������setAccessible(true)
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		Class clazz = Class.forName("com.hsd.demo1.Person");
		
		Constructor con =  clazz.getDeclaredConstructor(String.class);
	
		con.setAccessible(true);
		
		Person p = (Person) con.newInstance("haha");
	}
	
	@Test
	/**
	 * ������еĹ��췽��
	 * @throws Exception
	 */
	public void test2() throws Exception{
		Class clazz =  Class.forName("com.hsd.demo1.Person");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
	}

}
