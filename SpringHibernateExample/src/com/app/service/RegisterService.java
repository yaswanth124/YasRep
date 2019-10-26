package com.app.service;

import java.util.List;


import com.app.pojo.RegisterPojo;




public interface RegisterService {

	/*public void addUser(RegisterPojo user);*/

	public List<RegisterPojo> getUser();

	public void addUser(String firstName, String lastName, String dob, String age, String gender, String mobileNo,
			String email, String pwd, String tempAdd, String permAdd);

	public void deleteEmployee(RegisterPojo user);

	public RegisterPojo getEmployee(int id);

	public List<RegisterPojo> updateUser(RegisterPojo user);

	
}


