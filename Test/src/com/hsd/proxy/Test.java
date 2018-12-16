package com.hsd.proxy;

public class Test {
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new Target());
		proxy.query();
		System.out.println();
		proxy.update();
	}
}
