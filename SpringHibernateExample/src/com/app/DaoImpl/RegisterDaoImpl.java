package com.app.DaoImpl;

import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Dao.RegisterDao;
import com.app.pojo.RegisterPojo;


@Repository("userDao")
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private SessionFactory sessionfactory;

	
	@Override
	public List<RegisterPojo> getUser() {

		Session session = sessionfactory.openSession();
		String SQL_QUERY = " from RegisterPojo ";
		Query q = session.createQuery(SQL_QUERY);
		/*q.setParameter("userId", "html003");*/

		List<RegisterPojo> userlist = q.list();
		session.close();
		return userlist;
	}

	@Override
	public void saveUser(String firstName, String lastName, String dob, String age, String gender, String mobileNo,
			String email, String pwd, String tempAdd, String permAdd) {
		
		Session session = sessionfactory.openSession();
		
		Transaction tx=session.beginTransaction();
		tx.begin();
		try {
			String hql = "select max(id) from RegisterPojo";
			Query q = session.createQuery(hql);
			List<Integer> l = q.list();
			Integer[] arr = (Integer[]) l.toArray(new Integer[l.size()]);

			System.out.println("array of collection" + arr[0]);
			System.out.println();
			String userI = "html_0";
			String userId = userI.concat(String.valueOf(arr[0] + 1));
			System.out.println("auto generate id using array===" + userId);
			System.out.println(userId);
			tx = session.beginTransaction();
			tx.begin();
			
			RegisterPojo rp=new RegisterPojo();
			rp.setUserId(userId);
			rp.setFirstName(firstName);
			rp.setLastName(lastName);
			rp.setDob(dob);
			rp.setAge(age);
			rp.setGender(gender);
			rp.setMobileNo(mobileNo);
			rp.setEmail(email);
			rp.setTempAdd(tempAdd);
			rp.setPermAdd(permAdd);
			rp.setPwd(pwd);
			session.save(rp);
		} catch (NullPointerException e) {
			System.out.println("am in first time running catch block ");
			System.out.println(e);
			String userId = "html_01";
			RegisterPojo rp=new RegisterPojo();
			rp.setUserId(userId);
			rp.setFirstName(firstName);
			rp.setLastName(lastName);
			rp.setDob(dob);
			rp.setAge(age);
			rp.setGender(gender);
			rp.setMobileNo(mobileNo);
			rp.setEmail(email);
			rp.setTempAdd(tempAdd);
			rp.setPermAdd(permAdd);
			rp.setPwd(pwd);
			session.save(rp);
		}
		System.out.println("successfully inserted");
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void deleteEmployee(RegisterPojo user) {
		Session session = sessionfactory.openSession();
		String hql="DELETE FROM RegisterPojo WHERE id = "+user.getId();
		Query q=session.createQuery(hql);
		q.executeUpdate();
		session.close();
		
	}

	@Override
	public RegisterPojo getEmployee(int id) {
		/*Session session = sessionfactory.openSession();*/
		
		return (RegisterPojo) sessionfactory.getCurrentSession().get(RegisterPojo.class, id);
		
		
	}

	@Override
	public List<RegisterPojo> updatepojo(RegisterPojo user) {
		System.out.println("am in updatepojo");
		System.out.println(user.getId());
		
		Session session = sessionfactory.openSession();
		
		String hql="update RegisterPojo set id=:id,firstName=:firstName,lastName=:lastName,dob=:dob,age=:age,gender=:gender,mobileNo=:mobileNo,email=:email,pwd=:pwd,tempAdd=:tempAdd,permAdd=:permAdd,photo=:photo where userId=:userId";
				
				
		Query q=session.createQuery(hql);
		q.setParameter("userId",user.getUserId() );
		q.setParameter("firstName", user.getFirstName());
		q.setParameter("lastName", user.getLastName());
		q.setParameter("dob", user.getDob());
		q.setParameter("age", user.getAge());
		q.setParameter("gender", user.getGender());
		q.setParameter("mobileNo", user.getMobileNo());
		q.setParameter("email", user.getEmail());
		q.setParameter("pwd", user.getPwd());
		q.setParameter("tempAdd", user.getTempAdd());
		q.setParameter("permAdd", user.getPermAdd());
		q.setParameter("id", user.getId());
		int i=q.executeUpdate();
		System.out.println("rows affected=" +i);
		String hql2="from RegisterPojo";
		Query q1=session.createQuery(hql2);
		List l=q1.list();
		return l;
		
	}
}
	
	
	


