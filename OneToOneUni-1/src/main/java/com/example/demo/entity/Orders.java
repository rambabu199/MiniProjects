package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
	@Id
	private int id;
	private String name;
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adr_id",referencedColumnName = "id")
	private Address adr;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", price=" + price + ", adr=" + adr + "]";
	}
	

}
