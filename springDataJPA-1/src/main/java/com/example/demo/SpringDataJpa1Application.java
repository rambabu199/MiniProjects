package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class SpringDataJpa1Application implements CommandLineRunner{
private StudentRepository str;
	public SpringDataJpa1Application(StudentRepository str) {
	super();
	this.str = str;
}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s=new Student();
		s.setName("babu");
		s.setCity("gun");
		str.save(s);
		System.out.println("count=:"+str.count());
		System.out.println("getting all:"+str.findAll());
		//str.deleteById(1);
		//str.deleteAll();
		Student st=str.findById(8).orElse(null);
		if(st!=null)
		{
			st.setName("rambabu");
			str.save(st);
		}
	}

}
