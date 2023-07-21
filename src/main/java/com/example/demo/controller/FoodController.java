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

@RestController
@RequestMapping("/food")
public class FoodController {
	
	private FoodService foodService;

	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}
	
	@PostMapping()
	public Food saveFood(@RequestBody Food Food) {
		return foodService.saveFood(Food);
	}
	
	@GetMapping()
	public List<Food> getFoodes(){
		return foodService.getFood();
	}
	
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable("id") long id) {
		return foodService.getFoodById(id);
	}
	
	@PutMapping("/{id}")
	public Food updateFood(@RequestBody Food Food, @PathVariable("id") long id) {
		return foodService.updateFood(Food, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable("id") long id) {
		foodService.deleteFood(id);
		
		return new ResponseEntity<String>("Food deleted Successfully", HttpStatus.OK);
	}
}
