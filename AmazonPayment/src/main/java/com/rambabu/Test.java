package com.rambabu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		Amazon a1=a.getBean("ama",Amazon.class);
		System.out.println(a1.doPament(205.22));

	}

}
