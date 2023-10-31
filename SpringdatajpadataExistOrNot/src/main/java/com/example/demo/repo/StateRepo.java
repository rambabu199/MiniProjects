package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}
