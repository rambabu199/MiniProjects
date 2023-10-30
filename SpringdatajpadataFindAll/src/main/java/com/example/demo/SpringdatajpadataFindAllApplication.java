package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@SpringBootApplication
public class SpringdatajpadataFindAllApplication implements CommandLineRunner{
	@Autowired
	private StudentRepo sr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataFindAllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Student s=new Student();
		s.setName("ram");
		s.setAge(25);
		sr.save(s);
		Student s1=new Student();
		s1.setName("babu");
		s1.setAge(20);
		sr.save(s1);
		*/
		List <Student> s=sr.findAll();
		s.forEach((p)->{
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getAge());
			
		});
		
		
	}

}
