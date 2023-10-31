package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
