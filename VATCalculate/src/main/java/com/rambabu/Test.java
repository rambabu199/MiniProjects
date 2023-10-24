package com.rambabu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		Central a1=a.getBean("cen",Central.class);
		System.out.println(a1.showVat(200.50));

	}

}
