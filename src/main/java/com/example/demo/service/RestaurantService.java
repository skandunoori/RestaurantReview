package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Restaurant;

/**
 * The Restaurant Service interface defines the methods for managing CRUD operations on restaurant entities.
 * It provides methods to create, read, update, and delete restaurants in the system.
 */
public interface RestaurantService {
	
	/**
	 * Create a new restaurant in the database.
	 * 
	 * @param restaurant The restaurant object to be saved.
	 * @return The saved restaurant object.
	 */
	Restaurant saveRestaurant(Restaurant restaurant);
	
	/**
	 * Get all restaurants from the database.
	 * 
	 * @return A list containing all restaurants stored in the database.
	 */
	List<Restaurant> getRestaurants();
	
	/**
	 * Get a restaurant by its ID from the database.
	 * 
	 * @param id The ID of the restaurant to retrieve.
	 * @return The restaurant object with the specified ID, or null if not found.
	 */
	Restaurant getRestaurantById(Long id);
	
	/**
	 * Update an existing restaurant in the database.
	 * 
	 * @param restaurant The restaurant object containing updated restaurant details.
	 * @param id The ID of the restaurant to be updated.
	 * @return The updated restaurant object.
	 */
	Restaurant updateRestaurant(Restaurant restaurant, Long id);
	
	/**
	 * Delete a restaurant from the database.
	 * 
	 * @param id The ID of the restaurant to be deleted.
	 */
	void deleteRestaurant(Long id);
	
	

}
