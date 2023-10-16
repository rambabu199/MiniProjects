package com.bitlabs.jobportaljdbc;

public class Recruter {

	private int rid;
	private String name;
	private String company_name;
	private String designation;
	private String mail_ID;
	private Long mobile_number;
	public Recruter( int rid,String name,String company_name,String designation,String mail_ID,Long mobile_number)
	{
		this.rid=rid;
		this.name=name;
		this.company_name=company_name;
		this.designation=designation;
		this.mail_ID=mail_ID;
		this.mobile_number=mobile_number;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMail_ID() {
		return mail_ID;
	}
	public void setMail_ID(String mail_ID) {
		this.mail_ID = mail_ID;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	@Override
	public String toString() {
		return "Recruter [rid=" + rid + ", name=" + name + ", company_name=" + company_name + ", designation="
				+ designation + ", mail_ID=" + mail_ID + ", mobile_number=" + mobile_number + "]";
	}
	

}
