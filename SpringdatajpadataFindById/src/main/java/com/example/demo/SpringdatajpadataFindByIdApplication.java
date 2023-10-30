package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@SpringBootApplication
public class SpringdatajpadataFindByIdApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepo emprepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataFindByIdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1=new Employee();
		e1.setName("rambabu");
		e1.setAddress("Vij");
		emprepo.save(e1);
		
		Employee emp=emprepo.findById(e1.getId()).get();
		System.out.println(emp);
		
		
	}

}
