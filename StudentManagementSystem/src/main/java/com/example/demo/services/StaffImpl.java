package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class StaffImpl {
private int id;
private String name;
private double salary;
private String address;
private String designation;
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
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
@Override
public String toString() {
	return "Staff [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + ", designation="
			+ designation + "]";
}



}
