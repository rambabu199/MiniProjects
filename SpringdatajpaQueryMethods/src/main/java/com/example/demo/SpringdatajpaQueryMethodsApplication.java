package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@SpringBootApplication
public class SpringdatajpaQueryMethodsApplication implements CommandLineRunner {
	@Autowired
	private ProductRepo pr;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaQueryMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Product p=new Product();
		p.setName("laptop");
		p.setPrice(10000);
		Product p1=new Product();
		p1.setName("mobile");
		p1.setPrice(20000);
		Product p2=new Product();
		p2.setName("TV");
		p2.setPrice(15000);
		pr.saveAll(List.of(p,p1,p2));*/
		/*List<Product>p=pr.findByPriceGreaterThan(20000);
		p.forEach((p1)->{
			System.out.println(p1);
		}
		
				);
		List<Product>p2=pr.findByPriceLessThan(50000);
		p2.forEach((p3)->{
			System.out.println(p3);
		});
		
		List<Product>pro=pr.findByPriceBetween(100, 250000);
		pro.forEach((pro1)->{
			System.out.println(pro1);
		});*/
		List<Product>pro=pr.findByNameLike("laptop");
		pro.forEach((p1)->{
			System.out.println(p1);
		});
		
		
		
		
	}

}
