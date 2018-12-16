package com.hsd.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
	
	@org.junit.Test
	public void test() {
		//加载hibernate的核心配置文件
		Configuration cfg = new Configuration().configure();
		
		//创建一个SessionFactory对象
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//通过sessionFactroy获得session对象
		Session session = sessionFactory.openSession();
		
		//手动开启事务
		Transaction transaction = session.beginTransaction();
		
		//编写代码
		Customer customer = new Customer();
		
		customer.setName("hibenate");
		customer.setAge(20);
		
		session.save(customer);
		
		//提交事务
		transaction.commit();
		
		//释放资源
		session.close();
		sessionFactory.close();
		
		
		
	}

}
