package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Student implements  Comparable<Student> {
	private int Id;
	private String name;
	private long mobilenumber;
	private String address;
	private String branch;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", mobilenumber=" + mobilenumber + ", address=" + address
				+ ", branch=" + branch + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.Id, o.Id);
	}
	
	
	

}
