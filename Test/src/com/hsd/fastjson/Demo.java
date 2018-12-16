package com.hsd.fastjson;

import org.junit.Test;
import com.alibaba.fastjson.JSON;


public class Demo {
	
	@Test
	public void test() {
		User user = new User();
		user.setUsername("����");
		user.setPassword("123");
		
		  //���ｫjavabeanת����json�ַ��� 
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
		
		 //���ｫjson�ַ���ת����javabean����,  
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
