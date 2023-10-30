package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer>{

}
