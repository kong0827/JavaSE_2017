package com.hsd.design;

public class GoogleCar implements Car{

	@Override
	public void start() {
		System.out.println("汽车启动了");
		
	}

	@Override
	public void run() {
		System.out.println("汽车运行了");
		
	}

	@Override
	public void stop() {
		System.out.println("汽车停止了");
		
	}

}
