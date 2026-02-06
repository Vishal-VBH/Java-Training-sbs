package com.exception.tasks;

public class MarathonRegister {

/*
Write a java code to register a candidate for Marathon
the program should take name, age, gender and contact as input
name should contain only string value with minimum 4 characters
age should be between 18 to 60
gender should have values like , Male/Female/Others
contact should be numeric having exactly 10 digits
All the exceptions should be handled properly and once user enters 
all correct data, code should allow the user to register successfully.
*/
	String name;
	int age;
	String gender;
	String contact;
	
	public MarathonRegister(String name, int age, String gender, String contact) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
		
		
}
