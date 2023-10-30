package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

}
