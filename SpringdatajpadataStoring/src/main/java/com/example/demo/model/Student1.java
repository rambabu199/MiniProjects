package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Student1 {

	@Id
	private int id;
	private String name;
	private int age;
	
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student1(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

}
