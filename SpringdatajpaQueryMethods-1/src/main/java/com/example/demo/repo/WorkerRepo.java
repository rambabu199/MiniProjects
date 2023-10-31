package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Worker;

public interface WorkerRepo extends JpaRepository<Worker, Integer> {
	List<Worker>findByNameLike(String name);
	List<Worker>findDistinctByname(String name);
	

}
