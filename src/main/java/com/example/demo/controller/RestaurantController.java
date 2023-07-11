package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RestaurantRepo;
import com.example.demo.model.Restaurant;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@PostMapping("/restaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant res){
		System.out.println(res.toString());
		
		return restaurantRepo.save(res);
	}

}
