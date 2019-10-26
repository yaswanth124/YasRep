package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.dao.SDao;
import com.student.model.Student;
@Component("ser11")
public class ServiceImpl implements IService {
	@Autowired
	private SDao dao;

	@Override
	public void insert(Student std) {
		// TODO Auto-generated method stub
		
			try {
				dao.insert(std);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public List<Student> viewpage() {
		// TODO Auto-generated method stub
		List<Student> studentDetails=null;
		try {
		studentDetails=dao.viewpage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( studentDetails);
		return studentDetails;
	}

	@Override
	public void delet(int id) {
		// TODO Auto-generated method stub
		dao.delet(id);
		
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		Student std=dao.detById(id);
		return std;
	}

	@Override
	public void update1(Student std) {
		// TODO Auto-generated method stub
		dao.update1(std);
		
	}

	
}
