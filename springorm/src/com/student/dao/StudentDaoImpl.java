package com.student.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.model.Student;
@Component("std11")
public class StudentDaoImpl implements SDao  {

	@Autowired
	private SessionFactory sessionfactory;

	
	@Override
	public void insert(Student std) {
		// TODO Auto-generated method stub
		org.hibernate.Session ses=null;
		org.hibernate.Transaction tx=null;
		
		 try {
			 System.out.println("im in daoimpl");
			 ses= sessionfactory.openSession();
			 tx=ses.beginTransaction();
			 tx.begin();
			 ses.saveOrUpdate(std);
		
			 System.out.println("insert success");
			 tx.commit();
			 
		} catch (Exception e) {
			System.out.println("inser failure exception"+ e);
		}finally {
			
			ses.close();
		}
		
		
		
	}


	@Override
	public List<Student> viewpage() {
		// TODO Auto-generated method stub
		
		
		org.hibernate.classic.Session ses=null;
		org.hibernate.Transaction tx=null;
		List<Student> studentDetails=null;
	try {
		ses= sessionfactory.openSession();
		tx=ses.beginTransaction();
		String hql="from com.student.model.Student";
		Query q = ses.createQuery(hql);
		studentDetails = q.list();
		System.out.println("studentDetails DAO IMPL"+studentDetails);
		ses.close();
		
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return studentDetails;
	
	}


	@Override
	public void delet(int id) {
		// TODO Auto-generated method stub
			org.hibernate.Session ses=null;
		org.hibernate.Transaction tx=null;
		Student std=null;
		System.out.println("im in delete method");
		 try {
			 System.out.println("im in daoimpl");
			 ses= sessionfactory.openSession();
			 tx=ses.beginTransaction();
		
				tx.begin(); 
	 	 	 	std=(Student)ses.get(Student.class, id);  	 	
	 	 	 	ses.delete(std);  	 	 	tx.commit(); 

		} catch (Exception e) {
			System.out.println("inser failure exception"+ e);
		}finally {
			
			ses.close();
		}
		
		
	}


	@Override
	public Student detById(int id) {
		// TODO Auto-generated method stub
		org.hibernate.Session ses=null;
		org.hibernate.Transaction tx=null;
		Student std=null;
		
		 try {
			 System.out.println("im in daoimpl");
			 ses= sessionfactory.openSession();
			 tx=ses.beginTransaction();
		
				tx.begin(); 
	 	 	 	 	
	 	 		std=(Student)ses.get(Student.class, id); 	 	 
	 	 	 	tx.commit(); 

		} catch (Exception e) {
			System.out.println("inser failure exception"+ e);
		}finally {
			
			ses.close();
		}
		
		return std;
	}


	@Override
	public void update1(Student std) {
		// TODO Auto-generated method stub
		
		
		org.hibernate.Session ses=null;
		org.hibernate.Transaction tx=null;
		
		 try {
			 System.out.println("im in daoimpl");
			 ses= sessionfactory.openSession();
			 tx=ses.beginTransaction();
			 tx.begin();
			 ses.saveOrUpdate(std);
		
			 System.out.println("insert success");
			 tx.commit();
			 
		} catch (Exception e) {
			System.out.println("inser failure exception"+ e);
		}finally {
			
			ses.close();
		}
		
	}

}
