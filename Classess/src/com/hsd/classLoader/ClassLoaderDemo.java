package com.hsd.classLoader;

public class ClassLoaderDemo {
	public static void main(String[] args) {
		//����ֽ������
		Class<ClassLoader> clazz = ClassLoader.class;
		//����������
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println(classLoader);

	}

}
