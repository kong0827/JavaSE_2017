package com.hsd.factory;

public class DogFactory extends Factory{

	@Override
	public Animal createAnimal() {
		
		return new Dog();
	}

}
