package com.hsd.test;

public class FilterPersonBySalary implements MyPredicate<Person>{

	@Override
	public boolean test(Person t) {
		
		return t.getSalary()>5000;
	}

}
