package com.hsd.demo1;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class Demo1 {
	
	@Test
	public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class clazz = Class.forName("com.hsd.demo1.Person");
		Person person = (Person) clazz.newInstance();
		person.say();
	}
	
	@Test
	public void test2() throws Exception{
		Class<Person> clazz = Person.class;
		Constructor<Person> constructor = clazz.getConstructor();
		Person person = constructor.newInstance();
		person.say();
		
	}
	

}
