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

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@PostMapping("/restaurant/{restaurantId}/user/{userId}")
	public Comment saveComment(@RequestBody Comment comment, @PathVariable("restaurantId") long restaurantId,
			@PathVariable("userId") long userId) {
		return commentService.saveComment(comment, restaurantId, userId);
	}
	
	@GetMapping()
	public List<Comment> getComments() {
		return commentService.getComments();
	}
	
	@GetMapping("/{id}")
	public Comment getCommentById(@PathVariable("id") long id) {	
		return commentService.getCommentById(id);
	}
	
	@PutMapping("/{id}")
	public Comment updateComment(@RequestBody Comment comment, @PathVariable("id") long id) {
		return commentService.updateComment(comment, id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") long id) {
		commentService.deleteComment(id);
		
		return new ResponseEntity<String>("Comment deleted succesfully", HttpStatus.OK);
	}

}
