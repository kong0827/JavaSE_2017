package com.hsd.factory;

public class CatFactory  extends Factory{
	
	public  Animal createAnimal() {
		return new Cat();
	}
}
