package com.hsd.fastjson;

import org.junit.Test;
import com.alibaba.fastjson.JSON;


public class Demo {
	
	@Test
	public void test() {
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		
		  //这里将javabean转化成json字符串 
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
		
		 //这里将json字符串转化成javabean对象,  
		user =JSON.parseObject(jsonString,User.class);  
	    System.out.println(user.getUsername());  
	}

}

class User{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
