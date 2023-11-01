package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Marks;
import com.example.demo.entity.Student;
import com.example.demo.repo.MarksRepo;
import com.example.demo.repo.StudentRepo;

@SpringBootApplication
public class OneToOneUni2Application implements CommandLineRunner{
	@Autowired
	private MarksRepo mr;
	@Autowired
	private StudentRepo sr;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUni2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s=new Student();
		s.setId(1);
		s.setName("ram");
		Marks m=new Marks();
		m.setId(1);
		m.setMarks(85);
		s.setMarks(m);
		sr.save(s);
		
	}

}
