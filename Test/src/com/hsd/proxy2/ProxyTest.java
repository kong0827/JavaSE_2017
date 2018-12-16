package com.hsd.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	
	Target target = new Target();
	
	@Test
	public void test(){
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//System.out.println(method.getName());
				Object invoke = null;
				if(method.getName().equals("method1")){
					System.out.println("¼ÓÇ¿ÏÂ");
					invoke = method.invoke(target, args);
				}else{
					invoke = method.invoke(target, args);
				}
				
				return invoke;
			}
		});
		
		proxy.method1();
		String method2 = proxy.method2();
		System.out.println(method2);
	}
	
	

}
