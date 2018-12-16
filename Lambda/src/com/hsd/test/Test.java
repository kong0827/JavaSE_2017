package com.hsd.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	List<Person> persons = Arrays.asList(
		new Person("张三",18,4000),
		new Person("李四",19,5000),
		new Person("王五",20,6000)
	);
	
	public List<Person> filterPsersons(List<Person> persons, MyPredicate mp){
		List<Person> list = new ArrayList();
		for(Person p : persons){
			if(mp.test(p)){
				list.add(p);
			}
		}
		
		return list;
	}
	
	@org.junit.Test
	public void test(){
		List<Person> personList  = filterPsersons(persons, new FilterPersonBySalary()); 
		for (Person person : personList) {
			System.out.println(person);
		}
		
	}
	
	@org.junit.Test
	public void test2(){
		persons.stream()
						.filter((person)->person.getSalary()>4000)
						.forEach(System.out::println);
		
		//取出名字
		persons.stream().map(Person::getName).forEach(System.out::println);
	}

}
