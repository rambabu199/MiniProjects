package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.controller.ControllerClass;

@SpringBootApplication
public class AutowiredAnnotation2Application {

	public static void main(String[] args) {
		ApplicationContext c=SpringApplication.run(AutowiredAnnotation2Application.class, args);
		ControllerClass c1=c.getBean(ControllerClass.class);
		System.out.println(c1.dopaymen1t()+" \n"+c1.dopayment()+" \n"+c1.dopayment2());
	
	
	}

}
