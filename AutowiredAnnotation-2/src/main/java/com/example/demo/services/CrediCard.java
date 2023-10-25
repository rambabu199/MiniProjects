package com.example.demo.services;

import org.springframework.stereotype.Component;

@Component	
public class CrediCard  implements Payment{

	@Override
	public String paybill() {
		// TODO Auto-generated method stub
		return "i want to paybill by using credit card";
	}

}
