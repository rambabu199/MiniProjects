package com.rambabu;

public class EMIClass implements Payment{

	@Override
	public String paybilll(double amount) {
		// TODO Auto-generated method stub
		return "amount: "+amount+" is paid Successfully through EMI's";
	}

}
