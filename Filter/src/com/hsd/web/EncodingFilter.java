package com.hsd.web;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletRequest enhanceRequset  = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), 
				req.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						if(("getParameter").equals(method.getName())){
							String invoke = (String) method.invoke(req, args); //����
							invoke = new String(invoke.getBytes("iso-8859-1"),"utf-8");
							return invoke;
						}
						return method.invoke(req, args);
					}
				}
				);
		
		chain.doFilter( enhanceRequset , response);
	}
	
	public void destroy() {
		
	}


	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
