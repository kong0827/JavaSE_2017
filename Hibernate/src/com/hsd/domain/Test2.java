package com.hsd.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
	
	@org.junit.Test
	public void test() {
		//����hibernate�ĺ��������ļ�
		Configuration cfg = new Configuration().configure();
		
		//����һ��SessionFactory����
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//ͨ��sessionFactroy���session����
		Session session = sessionFactory.openSession();
		
		//�ֶ���������
		Transaction transaction = session.beginTransaction();
		
		//��д����
		Customer customer = new Customer();
		
		customer.setName("hibenate");
		customer.setAge(20);
		
		session.save(customer);
		
		//�ύ����
		transaction.commit();
		
		//�ͷ���Դ
		session.close();
		sessionFactory.close();
		
		
		
	}

}
