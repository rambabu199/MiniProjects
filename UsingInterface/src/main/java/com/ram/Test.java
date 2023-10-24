package com.ram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext a=new ClassPathXmlApplicationContext("bean.xml");
		 College c1=a.getBean("stuone", StudentOne.class);
		 c1.info();
		College c2=a.getBean("stutwo",StudentTwo.class);
		c2.info();

	}

}
