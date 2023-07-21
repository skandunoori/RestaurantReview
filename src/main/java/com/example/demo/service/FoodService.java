package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Food;

public interface FoodService {
	
	Food saveFood(Food food);
	
	List<Food> getFood();
	
	Food getFoodById(long id);
	
	Food updateFood(Food food, long id);
	
	void deleteFood(long id);
}
