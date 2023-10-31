package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String corrency;
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
	public String getCorrency() {
		return corrency;
	}
	public void setCorrency(String corrency) {
		this.corrency = corrency;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", corrency=" + corrency + "]";
	}
	
	
	
}
