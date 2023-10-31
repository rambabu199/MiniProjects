package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
	List<Product>findByPriceGreaterThan(double price);
	List<Product>findByPriceLessThan(double price);
	List<Product>findByPriceBetween(double price,double price1);
	List<String> findDistinctNames();
	List<Product> findByNameLike(String name);




}
