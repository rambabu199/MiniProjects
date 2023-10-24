package com.rambabu;

public class Andhra implements VATClass{

	double tax=20.0;
	@Override
	public String claculateVat(double amount) {
		tax=tax+amount;
		return "amount after added Andhra VAT="+tax;
	}

}
