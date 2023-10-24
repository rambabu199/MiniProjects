package com.rambabu;

public class Bank {
 private ATM atm;

public Bank(ATM atm) {
	super();
	this.atm = atm;
}
public String showdeposits()
{
	return atm.deposit();
}
public String showWithdraw()
{
	return atm.withdraw();
}


}
