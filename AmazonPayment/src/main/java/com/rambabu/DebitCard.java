package com.rambabu;

public class DebitCard implements Payment{

	@Override
	public String paybilll(double amount) {
		// TODO Auto-generated method stub
		return "amount: "+amount+"is paid successfully through the DebitCard";
	}

}
