package com.hsd.classLoader;

public class ClassLoaderDemo {
	public static void main(String[] args) {
		//获得字节码对象
		Class<ClassLoader> clazz = ClassLoader.class;
		//获得类加载器
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println(classLoader);

	}

}
