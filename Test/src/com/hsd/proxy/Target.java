package com.hsd.proxy;

public class Target implements Count{

	@Override
	public void query() {
		System.out.println("查询方法");
		
	}

	@Override
	public void update() {
		System.out.println("更新方法");
		
	}

}
