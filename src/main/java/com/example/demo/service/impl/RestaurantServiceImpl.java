package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RestaurantRepo;
import com.example.demo.model.Rating;
import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

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
	public Optional<Restaurant> getRestaurantById(Long id) {
		return restaurantRepository.findById(id);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}

}
