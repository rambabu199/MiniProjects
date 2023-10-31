package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Country;
import com.example.demo.repo.CountryRepo;

@SpringBootApplication
public class SpringdatajpadataUpdatingApplication implements CommandLineRunner{
	@Autowired
	CountryRepo cr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataUpdatingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Country c=new Country();
		c.setName("india");
		c.setCorrency("rupee");
		Country c1=new Country();
		c1.setName("usa");
		c1.setCorrency("dollor");
		cr.saveAll(List.of(c,c1));
		Country c2=cr.findById(2).get();
		c2.setName("canada");
		c2.setCorrency("dol");
		cr.save(c2);
		
	}

}
