package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.rambabu.ControllerClass;



@SpringBootApplication
public class ComponentAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext c=SpringApplication.run(ComponentAnnotationApplication.class,args);
		ControllerClass cc=c.getBean(ControllerClass.class);
		System.out.println(cc.display());
	}

}
