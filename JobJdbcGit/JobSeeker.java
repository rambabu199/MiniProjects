package com.bitlabs.jobportaljdbc;

public class JobSeeker {
	private int jsid;
	private String jsname;
	private String mail_ID;
	private Long mobile_number;
	private String key_skills;
	private int age;
	private String education;
	private String address;
	public JobSeeker(int jsid, String jsname, String mail_ID, Long mobile_number, String key_skills, int age,
			String education, String address) {
		//super();
		this.jsid = jsid;
		this.jsname = jsname;
		this.mail_ID = mail_ID;
		this.mobile_number = mobile_number;
		this.key_skills = key_skills;
		this.age = age;
		this.education = education;
		this.address = address;
	}
	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	public String getJsname() {
		return jsname;
	}
	public void setJsname(String jsname) {
		this.jsname = jsname;
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
	public String getKey_skills() {
		return key_skills;
	}
	public void setKey_skills(String key_skills) {
		this.key_skills = key_skills;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "JobSeeker [jsid=" + jsid + ", jsname=" + jsname + ", mail_ID=" + mail_ID + ", mobile_number="
				+ mobile_number + ", key_skills=" + key_skills + ", age=" + age + ", education=" + education + ", address="
				+ address + "]";
	}


}
