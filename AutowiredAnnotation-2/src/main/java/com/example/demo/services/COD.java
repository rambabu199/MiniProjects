package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component
public class COD implements Payment {

	@Override
	public String paybill() {
		// TODO Auto-generated method stub
		return "i want to pay bill useing cash";
	}

}
