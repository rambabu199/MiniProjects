package com.rambabu;

public class CODClass implements Payment{

	@Override
	public String paybilll(double amount) {
		// TODO Auto-generated method stub
		return "amount: "+amount+"is paid successfully throuh Cash On Delivary";
	}

}
