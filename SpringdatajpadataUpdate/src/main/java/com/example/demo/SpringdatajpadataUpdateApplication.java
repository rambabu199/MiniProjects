package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Patient;
import com.example.demo.repo.PatientRepo;

@SpringBootApplication
public class SpringdatajpadataUpdateApplication implements CommandLineRunner{
	@Autowired
	private PatientRepo pr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataUpdateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Patient p=new Patient();
		p.setName("balu");
		p.setAge(60);
		p.setDate("12202222");
		Patient p1=new Patient();
		p1.setName("king");
		p1.setAge(52);
		p1.setDate("2022/02/22");
		pr.saveAll(List.of(p,p1));*/
		Patient p=pr.findById(2).orElse(null);
		if(p!=null)
		{
			p.setName("lutherKing");
			p.setAge(41);
			pr.save(p);
		}
		System.out.println(pr.findById(2));
		
		
	}

}
