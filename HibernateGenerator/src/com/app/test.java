package com.app;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ses=sf.openSession();
		org.hibernate.Transaction tx=ses.beginTransaction();
		tx.begin();
		Student s=new Student();
		s.setName("yash");
		s.setGrade("a");
		s.setGroup("civil");
		ses.save(s);
		tx.commit();
		ses.close();
		
	}
}
