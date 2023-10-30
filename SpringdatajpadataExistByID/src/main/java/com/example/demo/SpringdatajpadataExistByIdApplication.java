package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Hospital;
import com.example.demo.repo.HospitalRepo;

@SpringBootApplication
public class SpringdatajpadataExistByIdApplication implements CommandLineRunner {
	@Autowired
	private HospitalRepo hr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataExistByIdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Hospital h=new Hospital();
		h.setName("appolo");
		h.setMobile(789456123L);
		h.setAddress("vij");
		Hospital h1=new Hospital();
		h1.setName("andhra hospitals");
		h1.setMobile(70006123L);
		h1.setAddress("guntur");
		Hospital h2=new Hospital();
		h2.setName("ramesh hospital");
		h2.setMobile(41000123L);
		h2.setAddress("vij");
		hr.saveAll(List.of(h,h1,h2));*/
		System.out.println(hr.existsById(5));
	}

}
