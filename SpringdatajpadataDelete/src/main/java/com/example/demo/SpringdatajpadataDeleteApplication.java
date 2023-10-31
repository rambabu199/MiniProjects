package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Human;
import com.example.demo.repo.HumanRepo;

@SpringBootApplication
public class SpringdatajpadataDeleteApplication  implements CommandLineRunner{
	@Autowired
	HumanRepo hr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataDeleteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Human h=new Human();
		//h.setColor("white");
		//h.setNation("usa");
		//h.setColor("brown");
		//h.setNation("india");
	//	hr.save(h);
		//hr.deleteById(1);
		hr.deleteAll();
		
	}

}
