package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RestaurantRepo;
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
	
//	@GetMapping("/restaurant")

	@PostMapping()
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant){		
		return restaurantService.saveRestaurant(restaurant);
	}

}
