package com.hsd.proxy;

public class Proxy implements Count{
	Target target = new Target();
	
	

	public Proxy(Target target) {
		super();
		this.target = target;
	}

	@Override
	public void query() {
		System.out.println("查询前的动作");
		target.query();
		System.out.println("查询后的动作");
		
	}

	@Override
	public void update() {
		System.out.println("更新前的动作");
		target.update();
		System.out.println("更新后的动作");
		
	}

}
