package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface IService
{

	public void insert(Student std);

	

	public List<Student> viewpage();



	public void delet(int id);



	 public Student getById(int id);



	public void update1(Student std);





}
