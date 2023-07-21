package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.Rating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	private RatingService ratingService;
	
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	//create Rating REST API
	@PostMapping("/restaurant/{restaurantId}/user/{userId}")
	public Rating saveRating(@RequestBody Rating rating, @PathVariable("restaurantId") long restaurantId, 
			@PathVariable("userId") long userId) {
		return ratingService.saveRating(rating, restaurantId, userId);
	}
	
	@GetMapping()
	public List<Rating> getRatings() {
		return ratingService.getRatings();
	}
	
	@GetMapping("/{id}")
	public Rating getRatingById(@PathVariable("id") long id) {	
		return ratingService.getRatingById(id);
	}
	
	@PutMapping("/{id}")
	public Rating updateRating(@RequestBody Rating rating, @PathVariable("id") long id) {
		return ratingService.updateRating(rating, id);
	}
	
	@DeleteMapping("{id}")
	public void deleteRating(@PathVariable("id") long id) {
		ratingService.deleteRating(id);
	}

}
