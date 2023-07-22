package com.example.demo.controller;

import java.util.List;
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

/**
 * Controller class for managing CRUD operations on rating entities.
 */
@RestController
@RequestMapping("/rating")
public class RatingController {
	
	private RatingService ratingService;
	
	//Constructor to inject RatingService dependency
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	/**
	 * Create a new rating.
	 * 
	 * @param rating The Rating object containing rating details to be saved.
	 * @param restaurantId The Id of the restaurant the rating is provided on.
	 * @param userId The Id of the user who provided the rating.
	 * @return The saved rating object.
	 */
	@PostMapping("/restaurant/{restaurantId}/user/{userId}")
	public Rating saveRating(@RequestBody Rating rating, @PathVariable("restaurantId") long restaurantId, 
			@PathVariable("userId") long userId) {
		return ratingService.saveRating(rating, restaurantId, userId);
	}
	
	/**
	 * Get all ratings.
	 * 
	 * @return A list of all ratings in the database.
	 */
	@GetMapping()
	public List<Rating> getRatings() {
		return ratingService.getRatings();
	}
	
	/**
	 * Get a rating by its ID.
	 * 
	 * @param id The Id of the rating to retrieve.
	 * @return The Rating object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Rating getRatingById(@PathVariable("id") long id) {	
		return ratingService.getRatingById(id);
	}
	
	/**
	 * Update an existing rating by its ID.
	 * 
	 * @param rating The Rating object containing updated rating details.
	 * @param id The ID of the rating to be updated.
	 * @return The updated rating object.
	 */
	@PutMapping("/{id}")
	public Rating updateRating(@RequestBody Rating rating, @PathVariable("id") long id) {
		return ratingService.updateRating(rating, id);
	}
	
	/**
	 * Delete a rating by its ID.
	 * 
	 * @param id The ID of the rating to be deleted.
	 * @return ResponseEntity with a success message or an error message if the rating is not found.
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRating(@PathVariable("id") long id) {
		ratingService.deleteRating(id);
		
		return new ResponseEntity<String>("Rating deleted successfully", HttpStatus.OK);
	}

}
