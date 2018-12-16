import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test(){
		final Target target = new Target();
		
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object invoke = method.invoke(target, args);
						return invoke;
					}
					
				}
			
				); 
		
		proxy.method1();
		String str = proxy.method2();
		System.out.println(str);
		int i = proxy.method3(12);
		System.out.println(i);
	}

}
