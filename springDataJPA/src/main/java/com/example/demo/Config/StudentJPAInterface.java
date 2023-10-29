package com.example.demo.Config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.Student;

public interface StudentJPAInterface extends JpaRepository<Student, Integer>{

}
