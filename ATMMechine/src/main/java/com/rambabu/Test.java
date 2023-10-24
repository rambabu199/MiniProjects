package com.rambabu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String args[])
	{
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		Bank b=a.getBean("b1", Bank.class);
		System.out.println(b.showdeposits());
		System.out.println(b.showWithdraw());
	}
	
}
