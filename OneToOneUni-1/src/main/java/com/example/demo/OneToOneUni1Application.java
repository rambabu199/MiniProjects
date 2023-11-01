package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Address;
import com.example.demo.entity.Orders;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.OrderRepo;

@SpringBootApplication
public class OneToOneUni1Application implements CommandLineRunner{
	@Autowired
	private AddressRepo ar;
	@Autowired
	private OrderRepo or;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUni1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address a=new Address();
		a.setCity("vij");
		a.setId(1);
		ar.save(a);
		Orders o=new Orders();
		o.setId(1);
		o.setName("biryani");
		o.setPrice(275.00);
		o.setAdr(a);
		or.save(o);
		Address a1=new Address();
		a1.setCity("gun");
		a1.setId(2);
		ar.save(a1);
		Orders o1=new Orders();
		o1.setId(2);
		o1.setName("veg-biryani");
		o1.setPrice(175.00);
		o1.setAdr(a1);
		or.save(o1);
		
		Address a2=new Address();
		a2.setCity("mang");
		a2.setId(3);
		ar.save(a2);
		
		Address a3=new Address();
		a3.setCity("kur");
		a3.setId(4);
		ar.save(a3);
		Orders o2=new Orders();
		o2.setId(3);
		o2.setName("egg-biryani");
		o2.setPrice(215.00);
		o2.setAdr(a2);
	
		
		
		
				
		
	}

}
