package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface SDao {

	public void insert(Student std);

	public List<Student> viewpage();

	

	public void delet(int id);

	public Student detById(int id);

	public void update1(Student std);

	

}
