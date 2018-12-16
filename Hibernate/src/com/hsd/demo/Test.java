package com.hsd.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hsd.domain.Customer;
import com.hsd.utils.HibernateUtil;

public class Test {
	@org.junit.Test
	public void test(){
		Session session = HibernateUtil.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", 1));
		List list = criteria.list();
		
		System.out.println(list.toString());
		
	}
	

}
