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

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	private RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}

	@PostMapping()
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant){		
		return restaurantService.saveRestaurant(restaurant);
	}
	
	@GetMapping()
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants();
	}
	
	@GetMapping("/{id}")
	public Restaurant getRestaurantById(@PathVariable("id") long id) throws NotFoundException {
		return restaurantService.getRestaurantById(id);
	}
	
	@PutMapping("/{id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable("id") long id) throws NotFoundException {
		return restaurantService.updateRestaurant(restaurant, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") long id) {
		restaurantService.deleteRestaurant(id);
		
		return new ResponseEntity<String>("Restaurant deleted successfully", HttpStatus.OK);
	}

}
