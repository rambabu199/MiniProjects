package com.example.demo.jpa;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stu_table")
public class Student  {
	@Id
	//@Generated(Strategy=GenerationType.IDENTITY)
private int id;
private String name,city;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
}



}
