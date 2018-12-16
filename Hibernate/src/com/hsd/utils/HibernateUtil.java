package com.hsd.utils;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	// �Ự�������Ե�����ʽ����
	private static SessionFactory sessionFactory;

	// ThreadLocal�洢session
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();


	// �Ե�����ʽ����sessionFactory
	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("��ʼ���Ự����ʧ�ܣ�");
		}

	}
	//�õ�һ�������ĻỰ����
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	//��ȡһ����session
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	//��ȡ��ǰ���̰߳󶨵�session�������ȡ�����򴴽�һ����session���뵱ǰ�̰߳�
//	public static Session getCurrentSession() throws HibernateException {
//		//��ȡ��ǰ�̰߳󶨵�session
//		Session s = (Session) session.get();
//		if (s == null) {
//			//����һ����session
//			s = sessionFactory.openSession();
//			//��session���뵱ǰ�̰߳�
//			session.set(s);
//		}
//		return s;
//	}
 
	public static Session getCurrentSession() throws HibernateException {
		return sessionFactory.getCurrentSession(); 
	}
	//�رյ�ǰ�̰߳󶨵�session
//	public static void closeSession() throws HibernateException {
//		//��ȡ��ǰ�̰߳󶨵�session
//		Session s = (Session) session.get();
//		if (s != null){
//			//�ر�session
//			s.close(); 
//		}
//		session.set(null);
//	}
	
	public static void closeSession() throws HibernateException {
		sessionFactory.getCurrentSession().close();
	}


}


