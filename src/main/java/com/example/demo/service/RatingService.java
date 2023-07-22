package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Rating;

/**
 * The Rating Service interface defines the methods for managing CRUD operations on rating entities.
 * It provides methods to create, read, update, and delete ratings in the system.
 */
public interface RatingService {
	
	/**
	 * Create a new rating in the database.
	 * 
	 * @param rating The rating object to be saved.
	 * @param restaurantId The Id of the restaurant the rating is provided on.
	 * @param userId The Id of the user who provided the rating.
	 * @return The saved rating object.
	 */
	Rating saveRating(Rating rating, long restaurantId, long userId);
	
	/**
	 * Get all ratings from the database.
	 * 
	 * @return A list containing all ratings stored in the database.
	 */
	List<Rating> getRatings();
	
	/**
	 * Get a rating by its ID from the database.
	 * 
	 * @param id The ID of the rating to retrieve.
	 * @return The rating object with the specified ID, or null if not found.
	 */
	Rating getRatingById(Long id);
	
	/**
	 * Update an existing rating in the database.
	 * 
	 * @param rating The rating object containing updated rating details.
	 * @param id The ID of the rating to be updated.
	 * @return The updated rating object.
	 */
	Rating updateRating(Rating rating, Long id);
	
	/**
	 * Delete a rating from the database.
	 * 
	 * @param id The ID of the rating to be deleted.
	 */
	void deleteRating(Long id);
	
}
