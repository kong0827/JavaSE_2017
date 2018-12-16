package com.hsd.design;

public class Test {
	public static void main(String[] args) {
		/*GoogleCar gCar = new GoogleCar();
		gCar.start();
		gCar.run();
		gCar.stop();*/
		
		Car car = new MyCar(new GoogleCar());
		car.start();
		car.run();
		car.stop();
	}

}
