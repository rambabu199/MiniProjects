package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Human;

public interface HumanRepo extends JpaRepository<Human, Integer> {

}
