package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Amazon;

public interface AmazonRepo extends JpaRepository<Amazon, Integer>{

}
