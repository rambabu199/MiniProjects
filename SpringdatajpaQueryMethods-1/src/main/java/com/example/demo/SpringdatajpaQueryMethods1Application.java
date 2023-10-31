package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Worker;
import com.example.demo.repo.WorkerRepo;

@SpringBootApplication
public class SpringdatajpaQueryMethods1Application implements CommandLineRunner{
	@Autowired
	private WorkerRepo wr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaQueryMethods1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			/*Worker w=new Worker();
			w.setId(1);
			w.setName("ram");
			w.setWages(1200);
			Worker w1=new Worker();
			w1.setId(2);
			w1.setName("babu");
			w1.setWages(1000);
			Worker w2=new Worker();
			w2.setId(3);
			w2.setName("ram");
			w2.setWages(1500);
			Worker w3=new Worker();
			w3.setId(4);
			w3.setName("babu");
			w3.setWages(1200);
			wr.saveAll(List.of(w,w1,w2,w3));*/
		List<Worker>wo=wr.findByNameLike("ram");
		wo.forEach((p)->{
			System.out.println(p);
		});
		List<Worker>w1=wr.findDistinctByname("ram");
		w1.forEach((p)->{
			System.out.println(p);
		});
		
	}

}
