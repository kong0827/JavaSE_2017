package com.hsd.proxy;

public class Proxy implements Count{
	Target target = new Target();
	
	

	public Proxy(Target target) {
		super();
		this.target = target;
	}

	@Override
	public void query() {
		System.out.println("��ѯǰ�Ķ���");
		target.query();
		System.out.println("��ѯ��Ķ���");
		
	}

	@Override
	public void update() {
		System.out.println("����ǰ�Ķ���");
		target.update();
		System.out.println("���º�Ķ���");
		
	}

}
