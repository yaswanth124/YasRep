package com.app.DemoWeb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	// hello
public class Student {

	private String name;
	
	Private int k;
	private int points;
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
