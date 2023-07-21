package com.example.demo.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.Restaurant;

public interface RestaurantService {
	
	Restaurant saveRestaurant(Restaurant restaurant);
	 
	List<Restaurant> getRestaurants();
	
	Restaurant getRestaurantById(Long id) throws NotFoundException;
	
	Restaurant updateRestaurant(Restaurant restaurant, Long id) throws NotFoundException;
	
	void deleteRestaurant(Long id);
	
	

}
