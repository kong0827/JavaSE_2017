package com.hsd.decoration;

public class Test {
	public static void main(String[] args) {
		Animal animal = Factory.createAnimal("fish");
		if(animal!=null){
			animal.eat();
		}else{
			System.out.println("本工厂暂不生产该动物");
		}
	}

}
