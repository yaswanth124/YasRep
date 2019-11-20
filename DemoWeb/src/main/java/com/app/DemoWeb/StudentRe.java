package com.app.DemoWeb;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("studentRe")
public class StudentRe {
	
	StRepo lis =new StRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("mn")
	
	
	public List<Student> getStudent()
	{
	/*	List<Student> m=new ArrayList<Student>();
		Student s= new Student();
		s.setName("yaswanth");
		s.setPoints(40);
		
		Student s1= new Student();
		s1.setName("yash");
		s1.setPoints(400);
		
		m.add(s);
		m.add(s1);
		
		return m;*/
		
		return lis.getstd();
		
	}
	
	@GET
	@Path("getBy/{points}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getByid(@PathParam("points") int points) {
		return lis.getById(points);
	}
	
	@POST
	@Path("one")
	public Student createS(Student s)
	
	{
		System.out.println("im in create");
		lis.createS(s);
		return s;
	}
	@DELETE
	@Path("delete/{points}")
	public void delete(@PathParam("points") int points) {
		
		lis.delete(points);
	}
	
	@PUT
	@Path("update")
	public Student update(Student s) {
		
		if(lis.getById(s.getPoints()).getPoints()==0)
		
				{
			lis.createS(s);
				}
		else
		lis.update(s);
		
		
		return s;
	}
	
	
	
	
}
