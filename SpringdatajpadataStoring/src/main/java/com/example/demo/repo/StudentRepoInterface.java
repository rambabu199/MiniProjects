package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student1;

public interface StudentRepoInterface extends JpaRepository<Student1, Integer> {

}
