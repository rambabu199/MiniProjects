package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Library;
import com.example.demo.repo.LibraryRepo;

@SpringBootApplication
public class SpringdatajpadataDeleteAllApplication implements CommandLineRunner{
	@Autowired
	private LibraryRepo lr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataDeleteAllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Library lib=new Library();
		lib.setBookname("java");
		lib.setPrice(1000.50);
		Library lib1=new Library();
		lib1.setBookname("html");
		lib1.setPrice(500.50);
		Library lib2=new Library();
		lib2.setBookname("sql");
		lib2.setPrice(700.50);
		lr.saveAll(List.of(lib,lib1,lib2));*/
		lr.deleteAll();
		
		
	}

}
