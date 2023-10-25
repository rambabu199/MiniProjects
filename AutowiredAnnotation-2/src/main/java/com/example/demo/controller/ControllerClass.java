package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.services.COD;
import com.example.demo.services.CrediCard;
import com.example.demo.services.DebitCard;

@Component

public class ControllerClass {
private COD cod;
private CrediCard cc;
private DebitCard dc;
@Autowired
public void setCod(COD cod) {
	this.cod = cod;
}
@Autowired
public void setCc(CrediCard cc) {
	this.cc = cc;
}
@Autowired
public void setDc(DebitCard dc) {
	this.dc = dc;
}
public String dopayment()
{
	return cc.paybill();
}
public String dopaymen1t()
{
	return dc.paybill();
}

public String dopayment2()
{
	return cod.paybill();
}




}
