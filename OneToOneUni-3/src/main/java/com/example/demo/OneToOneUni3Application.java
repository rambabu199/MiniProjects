package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.EmployeeRepo;

@SpringBootApplication
public class OneToOneUni3Application implements CommandLineRunner{
	@Autowired
	private EmployeeRepo er;
	@Autowired
	private AddressRepo ar;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUni3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.setId(1);
		e.setName("ram");
		Address a=new Address();
		a.setId(1);
		a.setCity("vij");
		e.setAdr(a);
		er.save(e);
		
	}

}
