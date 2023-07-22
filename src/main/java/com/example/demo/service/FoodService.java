package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Food;

/**
 * The Food Service interface defines the methods for managing CRUD operations on food entities.
 * It provides methods to create, read, update, and delete food in the system.
 */
public interface FoodService {
	
	/**
	 * Create a new food in the database.
	 * 
	 * @param food The food object to be saved.
	 * @return The saved food object.
	 */
	Food saveFood(Food food);
	
	/**
	 * Get all food from the database.
	 * 
	 * @return A list containing all food stored in the database.
	 */
	List<Food> getFood();
	
	/**
	 * Get food by its ID from the database.
	 * 
	 * @param id The ID of the food to retrieve.
	 * @return The food object with the specified ID, or null if not found.
	 */
	Food getFoodById(long id);
	
	/**
	 * Update an existing food in the database.
	 * 
	 * @param food The food object containing updated food details.
	 * @param id The ID of the food to be updated.
	 * @return The updated food object.
	 */
	Food updateFood(Food food, long id);
	
	/**
	 * Delete food from the database.
	 * 
	 * @param id The ID of the food to be deleted.
	 */
	void deleteFood(long id);
}
