package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Rating;

public interface RatingService {
	
	Rating saveRating(Rating rating, long restaurantId, long userId);
	
	List<Rating> getRatings();
	
	Rating getRatingById(Long id);
	
	Rating updateRating(Rating rating, Long id);
	
	void deleteRating(Long id);
	
}
