package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FoodRepo;
import com.example.demo.model.Food;
import com.example.demo.service.FoodService;

/**
 * Class that implements FoodService interface
 */
@Service
public class FoodServiceImpl implements FoodService{
	
	private FoodRepo foodRepository;
	
	
	public FoodServiceImpl(FoodRepo foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	@Override
	public Food saveFood(Food food) {
		return foodRepository.save(food);
	}

	@Override
	public List<Food> getFood() {
		return foodRepository.findAll();
	}

	@Override
	public Food getFoodById(long id) {
		return foodRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Food Not Found"));
	}

	@Override
	public Food updateFood(Food food, long id) {
		Food _food = foodRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Food Not Found"));
		
		_food.setName(food.getName());
		_food.setIngredients(food.getIngredients());
		_food.setCuisine(food.getCuisine());
		
		return foodRepository.save(_food);
	}

	@Override
	public void deleteFood(long id) {
		foodRepository.deleteById(id);
	}

}
