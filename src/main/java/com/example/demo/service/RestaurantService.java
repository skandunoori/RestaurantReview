package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Restaurant;

public interface RestaurantService {
	
	Restaurant saveRestaurant(Restaurant restaurant);
	 
	List<Restaurant> getRestaurants();
	
	Optional<Restaurant> getRestaurantById(Long id);
	
	Restaurant updateRestaurant(Restaurant restaurant, Long id);
	
	void deleteRestaurant(Long id);
	
	

}
