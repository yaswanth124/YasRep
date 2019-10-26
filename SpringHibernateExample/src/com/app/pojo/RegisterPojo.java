package com.app.pojo;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "RegisterPojoSpring")
public class RegisterPojo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private String userId;
	private String firstName;
	private String lastName;
	private String dob;
	private String age;
	private String gender;
	private String mobileNo;
	private String email;
	private String pwd;
	private String tempAdd;
	private String permAdd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTempAdd() {
		return tempAdd;
	}
	public void setTempAdd(String tempAdd) {
		this.tempAdd = tempAdd;
	}
	public String getPermAdd() {
		return permAdd;
	}
	public void setPermAdd(String permAdd) {
		this.permAdd = permAdd;
	}
	@Override
	public String toString() {
		return "RegisterPojo [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", age=" + age + ", gender=" + gender + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", pwd=" + pwd + ", tempAdd=" + tempAdd + ", permAdd=" + permAdd + "]";
	}
	

}
