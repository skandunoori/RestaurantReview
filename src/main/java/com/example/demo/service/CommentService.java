package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;

/**
 * The Comment Service interface defines the methods for managing CRUD operations on comment entities.
 * It provides methods to create, read, update, and delete comments in the system.
 */
public interface CommentService {
	
	/**
	 * Create a new comment in the database.
	 * 
	 * @param comment The Comment object to be saved.
	 * @param restaurantId The Id of the restaurant the comment is provided on.
	 * @param userId The Id of the user who provided the comment.
	 * @return The saved comment object.
	 */
	Comment saveComment(Comment Comment, long restaurantId, long userId);
	
	/**
	 * Get all comments from the database.
	 * 
	 * @return A list containing all comments stored in the database.
	 */
	List<Comment> getComments();
	
	/**
	 * Get a comment by its ID from the database.
	 * 
	 * @param id The ID of the comment to retrieve.
	 * @return The Comment object with the specified ID, or null if not found.
	 */
	Comment getCommentById(Long id);
	
	/**
	 * Update an existing comment in the database.
	 * 
	 * @param comment The Comment object containing updated comment details.
	 * @param id The ID of the comment to be updated.
	 * @return The updated comment object.
	 */
	Comment updateComment(Comment comment, Long id);
	
	/**
	 * Delete a comment from the database.
	 * 
	 * @param id The ID of the comment to be deleted.
	 */
	void deleteComment(Long id);

}
