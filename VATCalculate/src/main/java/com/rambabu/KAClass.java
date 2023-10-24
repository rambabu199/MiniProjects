package com.rambabu;

public class KAClass implements VATClass {

	double tax=15.22;
	@Override
	public String claculateVat(double amount) {
		tax=tax+amount;
		return "amount after adding Karnataka VAT="+tax;
	}
	

}
