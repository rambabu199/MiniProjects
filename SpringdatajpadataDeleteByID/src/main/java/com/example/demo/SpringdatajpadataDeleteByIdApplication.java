package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Pizza;
import com.example.demo.repo.PizzaRepo;

@SpringBootApplication
public class SpringdatajpadataDeleteByIdApplication implements CommandLineRunner{
	@Autowired
	private PizzaRepo pr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataDeleteByIdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Pizza p=new Pizza();
		p.setName("vegpizza");
		p.setPrice(50.23);
		Pizza p1=new Pizza();
		p1.setName("non vegpizza");
		p1.setPrice(150.25);
		Pizza p2=new Pizza();
		p2.setName("chokopizza");
		p2.setPrice(100.23);
		Pizza p3=new Pizza();
		p3.setName("butterpizza");
		p3.setPrice(70.23);
		pr.saveAll(List.of(p,p1,p2,p3));*/
		pr.deleteById(1);
		
	}

}
