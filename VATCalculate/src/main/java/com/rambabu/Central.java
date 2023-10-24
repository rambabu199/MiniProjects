package com.rambabu;

public class Central {
VATClass vat;

public Central(VATClass vat) {
	super();
	this.vat = vat;
}
public String showVat(double amount) {
	return vat.claculateVat(amount);
}
}
