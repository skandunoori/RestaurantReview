package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;

public interface CommentService {
	
	Comment saveComment(Comment Comment, long restaurantId, long userId);
	
	List<Comment> getComments();
	
	Comment getCommentById(Long id);
	
	Comment updateComment(Comment comment, Long id);
	
	void deleteComment(Long id);

}
