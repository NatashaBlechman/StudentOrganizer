package com.myschooljournal.entity;

import java.util.List;

public class Teacher extends EntityObject{
	
	private String name;
	private String phoneNumber;
	private String email;
	private List<Lesson> lessons;
	public Teacher() {
		super();
	}
	public Teacher(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", lessons=" + lessons
				+ "]";
	}
	

}
