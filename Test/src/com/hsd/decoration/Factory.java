package com.hsd.decoration;

public class Factory {
	private Factory(){
		
	}
	public static Animal createAnimal(String type){
		if(type=="cat"){
			return new Cat();
		}
		if(type=="dog"){
			return new Dog();
		}
		return null;
	}

}
