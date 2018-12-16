package com.hsd.demo1;

public class Person {
	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private Person(String name) {
		System.out.println(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void say(){
		System.out.println("我是学生");
	}

	private void speak(){
		System.out.println("我在说悄悄话");
	}
}
