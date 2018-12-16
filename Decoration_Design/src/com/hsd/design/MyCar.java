package com.hsd.design;

public class MyCar implements Car {
	
	Car car;

	public MyCar(Car car) {
		super();
		this.car= car;
		
	}

	@Override
	public void start() {
		System.out.println("·�����ã���������");
		car.start();

	}

	@Override
	public void run() {
		car.run();
		
	}

	@Override
	public void stop() {
		car.stop();
		
	}

	

}
