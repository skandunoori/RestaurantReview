package com.example.demo.controller;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

/**
 * Controller class for managing CRUD operations on Restaurant entities.
 */
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
	
	private RestaurantService restaurantService;
	
	//Constructor to inject RestaurantService dependency
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}
	
	/**
	 * Create a new restaurant.
	 * 
	 * @param restaurant The Restaurant object containing restaurant details to be saved.
	 * @return The saved restaurant object.
	 */
	@PostMapping()
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant){		
		return restaurantService.saveRestaurant(restaurant);
	}
	
	/**
	 * Get all restaurants.
	 * 
	 * @return A list of all restaurants in the database.
	 */
	@GetMapping()
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants();
	}
	
	/**
	 * Get a restaurant by its ID.
	 * 
	 * @param id The Id of the restaurant to retrieve.
	 * @return The restaurant object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Restaurant getRestaurantById(@PathVariable("id") long id) throws NotFoundException {
		return restaurantService.getRestaurantById(id);
	}
	
	/**
	 * Update an existing restaurant by its ID.
	 * 
	 * @param restaurant The Restaurant object containing updated restaurant details.
	 * @param id The ID of the restaurant to be updated.
	 * @return The updated restaurant object.
	 */
	@PutMapping("/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable("id") long id) throws NotFoundException {
		return restaurantService.updateRestaurant(restaurant, id);
	}
	
	/**
	 * Delete a restaurant by its ID.
	 * 
	 * @param id The ID of the restaurant to be deleted.
	 * @return ResponseEntity with a success message or an error message if the restaurant is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") long id) {
		restaurantService.deleteRestaurant(id);
		
		return new ResponseEntity<String>("Restaurant deleted successfully", HttpStatus.OK);
	}

}
