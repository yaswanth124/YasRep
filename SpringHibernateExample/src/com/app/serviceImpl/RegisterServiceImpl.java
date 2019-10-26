package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.Dao.RegisterDao;
import com.app.pojo.RegisterPojo;
import com.app.service.RegisterService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterDao userDao;

	/*@Override
	public void addUser(RegisterPojo user) {
		userDao.saveUser(user);
	}*/

	@Override
	public List<RegisterPojo> getUser() {
		return userDao.getUser();
	}  

	@Override
	public void addUser(String firstName, String lastName, String dob, String age, String gender, String mobileNo,
			String email, String pwd, String tempAdd, String permAdd) {
		userDao.saveUser(firstName,lastName,dob,age,gender,mobileNo,email,pwd,tempAdd,permAdd);
		
	}

	@Override
	public void deleteEmployee(RegisterPojo user) {
		
		userDao.deleteEmployee(user);
	}

	@Override
	public RegisterPojo getEmployee(int id) {
		return userDao.getEmployee(id);
	}

	@Override
	public List<RegisterPojo> updateUser(RegisterPojo user) {
	return userDao.updatepojo(user);
		
	}

	
	

}
 