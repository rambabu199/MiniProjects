package com.job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		JobInterface j1=a.getBean("admin", AdminClass.class);
		j1.jobInfo();
		JobInterface j2=a.getBean("rec", RecruterClass.class);
		j2.jobInfo();
		JobInterface j3=a.getBean("jsk", JobseekerClass.class);
		j3.jobInfo();

	}

}
