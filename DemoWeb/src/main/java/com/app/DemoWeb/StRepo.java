package com.app.DemoWeb;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StRepo {

	

	List<Student> lis;
	Connection con=null;
	public   StRepo()
	{
		 try {
			 System.out.println("im in create");
				Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","yaswanth");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getstd()
	{
		lis =new ArrayList<Student>();
		String sql="select * from strepo";
		System.out.println("im in get by all");
		try {
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next()) {
				Student s=new Student();
				s.setPoints(rs.getInt(2));
				s.setName(rs.getString(1));
				
				lis.add(s);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lis;
	}
	
	public Student getById(int points)
	{
		Student s=new Student();
String sql="select * from strepo where points="+points;
System.out.println("im in get by points");
		try {
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if (rs.next()) {
			
				s.setPoints(rs.getInt(2));
				s.setName(rs.getString(1));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public void createS(Student s) {
		// TODO Auto-generated method stubs
		
String sql="insert into strepo values (?,?)";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(2, s.getPoints());
			st.setString(1, s.getName());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void delete(int points) {
		// TODO Auto-generated method stub
		
String sql="delete from strepo where points="+points;
		
		try {
			con.createStatement().executeQuery(sql);
			System.out.println("im in delete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void update(Student s) {
		// TODO Auto-generated method stubs
		
		String sql="update strepo set name=? where points=?";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
			System.out.println("im in update");
			
			st.setString(1, s.getName());
			st.setInt(2, s.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
