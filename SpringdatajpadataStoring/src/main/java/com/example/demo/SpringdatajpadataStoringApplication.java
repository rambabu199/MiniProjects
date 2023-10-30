package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student1;
import com.example.demo.repo.StudentRepoInterface;

@SpringBootApplication
public class SpringdatajpadataStoringApplication implements CommandLineRunner {
	@Autowired
	private StudentRepoInterface sri;
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataStoringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student1 s=new Student1();
		
		s.setName("babu");
		s.setAge(25);
		sri.save(s);
		
	}

}
