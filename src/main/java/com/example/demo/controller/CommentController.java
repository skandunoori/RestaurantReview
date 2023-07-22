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

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

/**
 * Controller class for managing CRUD operations on Comment entities.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private CommentService commentService;
	
	//Constructor to inject CommentService dependency
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	/**
	 * Create a new comment.
	 * 
	 * @param comment The Comment object containing comment details to be saved.
	 * @param restaurantId The Id of the restaurant the comment is provided on.
	 * @param userId The Id of the user who provided the comment.
	 * @return The saved comment object.
	 */
	@PostMapping("/restaurant/{restaurantId}/user/{userId}")
	public Comment saveComment(@RequestBody Comment comment, @PathVariable("restaurantId") long restaurantId,
			@PathVariable("userId") long userId) {
		return commentService.saveComment(comment, restaurantId, userId);
	}
	
	/**
	 * Get all comments.
	 * 
	 * @return A list of all comments in the database.
	 */
	@GetMapping()
	public List<Comment> getComments() {
		return commentService.getComments();
	}
	
	/**
	 * Get a comment by its ID.
	 * 
	 * @param id The Id of the comment to retrieve.
	 * @return The Comment object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Comment getCommentById(@PathVariable("id") long id) {	
		return commentService.getCommentById(id);
	}
	
	/**
	 * Update an existing comment by its ID.
	 * 
	 * @param comment The Comment object containing updated comment details.
	 * @param id The ID of the comment to be updated.
	 * @return The updated comment object.
	 */
	@PutMapping("/{id}")
	public Comment updateComment(@RequestBody Comment comment, @PathVariable("id") long id) {
		return commentService.updateComment(comment, id);
	}
	
	/**
	 * Delete a comment by its ID.
	 * 
	 * @param id The ID of the comment to be deleted.
	 * @return ResponseEntity with a success message or an error message if the comment is not found.
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") long id) {
		commentService.deleteComment(id);
		
		return new ResponseEntity<String>("Comment deleted succesfully", HttpStatus.OK);
	}

}
