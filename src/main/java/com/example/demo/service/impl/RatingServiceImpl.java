package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RatingRepo;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Rating;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	private RatingRepo ratingRepository;
	private RestaurantRepo restaurantRepository;
	private UserRepo userRepository;
	
	public RatingServiceImpl(RatingRepo ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}
	

	@Autowired
	public RatingServiceImpl(RatingRepo ratingRepository, RestaurantRepo restaurantRepository,
			UserRepo userRepository) {
		super();
		this.ratingRepository = ratingRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}



	@Override
	public Rating saveRating(Rating rating, long restaurantId, long userId) {
		Rating ratingObj = ratingRepository.save(rating);
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		Optional<User> user = userRepository.findById(userId);
		
		if(restaurant.isPresent()) {
			Restaurant resObj = restaurant.get();
			ratingObj.setRestaurant(resObj);
			resObj.getRatings().add(ratingObj);
			restaurantRepository.save(resObj);
		}
		
		if(user.isPresent()) {
			User userObj = user.get();
			ratingObj.setUser(userObj);
			userObj.getRatings().add(ratingObj);
			userRepository.save(userObj);
		}
		
		return ratingRepository.save(ratingObj);
	}


	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}


	@Override
	public Rating getRatingById(Long id) {
		Optional<Rating> _rating= ratingRepository.findById(id);
		Rating rating = null;
		if(_rating.isPresent()) {
			rating = _rating.get();
		}
		return rating;
	}


	@Override
	public Rating updateRating(Rating rating, Long id) {

		Optional<Rating> optRating = ratingRepository.findById(id);
		Rating _rating = null;
		if(optRating.isPresent()) {
			_rating = optRating.get();
			_rating.setValue(rating.getValue());
		}
		return ratingRepository.save(_rating);
	}


	@Override
	public void deleteRating(Long id) {
		ratingRepository.deleteById(id);
	}

}
