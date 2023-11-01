package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Marks;

public interface MarksRepo extends JpaRepository<Marks, Integer>{

}
