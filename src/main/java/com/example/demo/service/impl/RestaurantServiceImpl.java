package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

/**
 * Class that implements RestaurantService interface
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{

	private RestaurantRepo restaurantRepository;
	
	public RestaurantServiceImpl(RestaurantRepo restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		return restaurantRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Restaurant not found."));
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
		Restaurant _restaurant = restaurantRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("estaurant not found to update."));
		_restaurant.setName(restaurant.getName());
		
		return restaurantRepository.save(_restaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}

}
