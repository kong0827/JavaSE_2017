package com.hsd.proxy;

public class Target implements Count{

	@Override
	public void query() {
		System.out.println("��ѯ����");
		
	}

	@Override
	public void update() {
		System.out.println("���·���");
		
	}

}
