package com.hsd.factory;

public class Test {
	public static void main(String[] args) {
		
		Factory f1 = new CatFactory();
		Animal cat = f1.createAnimal();
		cat.eat();
		
		Factory f2 = new DogFactory();
		Animal dog = f2.createAnimal();
		dog.eat();
	}
}
