package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Worker {
	@Id
	private int id;
	private String name;
	private double wages;
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
	public double getWages() {
		return wages;
	}
	public void setWages(double wages) {
		this.wages = wages;
	}
	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", wages=" + wages + "]";
	}
	

}
