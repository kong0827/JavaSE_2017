package com.hsd.jdbc3;

import java.util.Date;

public class Stu {
	private int id;
	private String number;
	private String name;
	private Date birthday;
	private double wage;
	public Stu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", number=" + number + ", name=" + name + ", birthday=" + birthday + ", wage=" + wage
				+ "]";
	}
	 
	

}
