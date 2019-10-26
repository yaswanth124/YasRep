package com.app.Dao;

import java.util.List;


import com.app.pojo.RegisterPojo;



public interface RegisterDao {

/*public void saveUser ( RegisterPojo user );
*/
public List<RegisterPojo> getUser();
public void saveUser(String firstName, String lastName, String dob, String age, String gender, String mobileNo,
		String email, String pwd, String tempAdd, String permAdd);

public void deleteEmployee(RegisterPojo user);

public RegisterPojo getEmployee(int id);

public List<RegisterPojo> updatepojo(RegisterPojo user);
}
