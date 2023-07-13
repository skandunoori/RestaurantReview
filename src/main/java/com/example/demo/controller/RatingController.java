package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RatingRepo;
import com.example.demo.model.Rating;

@RestController
public class RatingController {
	
	@Autowired
	private RatingRepo repo;
	
	@PostMapping("/rating")
	public Rating addRating(@RequestBody Rating rating) {
		return repo.save(rating);
	}
	

}
