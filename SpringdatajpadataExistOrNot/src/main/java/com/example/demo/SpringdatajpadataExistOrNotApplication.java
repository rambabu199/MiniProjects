package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.State;
import com.example.demo.repo.StateRepo;

@SpringBootApplication
public class SpringdatajpadataExistOrNotApplication implements CommandLineRunner{
	@Autowired
	StateRepo sr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataExistOrNotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*State s=new State();
		s.setStatename("telangana");
		s.setCapital("hyd");
		State s1=new State();
		s1.setStatename("andhara");
		s1.setCapital("amaravathi");
		State s2=new State();
		s2.setStatename("karnataka");
		s2.setCapital("bangolore");
		sr.saveAll(List.of(s,s1,s2));*/
		
		boolean status=sr.existsById(5);
		System.out.println(status);

		
		
		
		
	}

}
