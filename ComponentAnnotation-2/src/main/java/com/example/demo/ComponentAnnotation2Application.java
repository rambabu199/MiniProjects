package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.ram.NonVegPizza;
import com.example.demo.ram.PizzaController;
import com.example.demo.ram.VegPizza;

@SpringBootApplication
public class ComponentAnnotation2Application {

	public static void main(String[] args) {
		ApplicationContext c=SpringApplication.run(ComponentAnnotation2Application.class,args);	
		VegPizza vp=c.getBean(VegPizza.class);
		System.out.println(vp.getpizza());
		NonVegPizza nvp=c.getBean(NonVegPizza.class);	
		System.out.println(nvp.getPizza());
		PizzaController pc=c.getBean(PizzaController.class);
		System.out.println(pc.getpizza());
}
	}
