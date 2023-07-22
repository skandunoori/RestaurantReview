package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;

/**
 * Controller class for managing CRUD operations on Food entities.
 */
@RestController
@RequestMapping("/food")
public class FoodController {
	
	private FoodService foodService;
	
	//Constructor to inject CommentService dependency
	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}
	
	/**
	 * Create a new Food item.
	 * 
	 * @param food The Food object containing food details to be saved.
	 * @return The saved Food object.
	 */
	@PostMapping()
	public Food saveFood(@RequestBody Food Food) {
		return foodService.saveFood(Food);
	}
	
	/**
	 * Get all Food.
	 * 
	 * @return A list of all food in the database.
	 */
	@GetMapping()
	public List<Food> getFoodes(){
		return foodService.getFood();
	}
	
	/**
	 * Get Food by its ID.
	 * 
	 * @param id The ID of the food to retrieve.
	 * @return The Food object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable("id") long id) {
		return foodService.getFoodById(id);
	}
	
	/**
	 * Update existing food by its ID.
	 * 
	 * @param food The Food object containing updated food details.
	 * @param id The ID of the food to be updated.
	 * @return The updated Food object.
	 */
	@PutMapping("/{id}")
	public Food updateFood(@RequestBody Food Food, @PathVariable("id") long id) {
		return foodService.updateFood(Food, id);
	}
	
	/**
	 * Delete food by its ID.
	 * 
	 * @param id The ID of the food to be deleted.
	 * @return ResponseEntity with a success message or an error message if the food is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable("id") long id) {
		foodService.deleteFood(id);
		
		return new ResponseEntity<String>("Food deleted Successfully", HttpStatus.OK);
	}
}
