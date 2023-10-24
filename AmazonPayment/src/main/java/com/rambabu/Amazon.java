package com.rambabu;

public class Amazon {
	Payment p;



	public void setP(Payment p) {
		this.p = p;
	}


	public String doPament(double amount) {
		return p.paybilll(amount);
	}

}
