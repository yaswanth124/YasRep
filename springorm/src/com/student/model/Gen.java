package com.student.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class Gen implements IdentifierGenerator  {

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix = "STUdent-"; 
 	 	String format = new SimpleDateFormat("yyyyMMdd").format(new Date()); 
 	 	int random = Math.abs(new Random().nextInt());  
 	 	return prefix+format+"-"+random; 


	}

     
}
 

