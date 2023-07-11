package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Food;

public interface FoodRepo extends JpaRepository<Food, Integer>{

}
