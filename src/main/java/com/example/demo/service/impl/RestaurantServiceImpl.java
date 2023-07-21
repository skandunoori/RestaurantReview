package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRepo;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.model.Address;
import com.example.demo.model.Rating;
import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	private RestaurantRepo restaurantRepository;
	
	private AddressRepo addressRepository;
	
	public RestaurantServiceImpl(RestaurantRepo restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		Address address = restaurant.getAddress();
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) throws NotFoundException {
		return restaurantRepository.findById(id).orElseThrow(
				() -> new NotFoundException());
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) throws NotFoundException {
		Restaurant _restaurant = restaurantRepository.findById(id).orElseThrow(
				() -> new NotFoundException());
		_restaurant.setName(restaurant.getName());
		
		return restaurantRepository.save(_restaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		restaurantRepository.deleteById(id);
	}

}
