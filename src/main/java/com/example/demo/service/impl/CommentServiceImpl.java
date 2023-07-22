package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentRepo;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Comment;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.CommentService;

/**
 * Class that implements CommentService interface
 */
@Service
public class CommentServiceImpl implements CommentService{
	
	private CommentRepo commentRepository;
	private RestaurantRepo restaurantRepository;
	private UserRepo userRepository;

	public CommentServiceImpl(CommentRepo commentRepository, RestaurantRepo restaurantRepository,
			UserRepo userRepository) {
		super();
		this.commentRepository = commentRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Comment saveComment(Comment Comment, long restaurantId, long userId) {
		Comment commentObj = commentRepository.save(Comment);
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
		Optional<User> user = userRepository.findById(userId);
		
		if(restaurant.isPresent()) {
			Restaurant resObj = restaurant.get();
			commentObj.setRestaurant(resObj);
			resObj.getComments().add(commentObj);
			restaurantRepository.save(resObj);
		}
		
		if(user.isPresent()) {
			User userObj = user.get();
			commentObj.setUser(userObj);
			userObj.getComments().add(commentObj);
			userRepository.save(userObj);
		}
		
		return commentRepository.save(commentObj);
	}

	@Override
	public List<Comment> getComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment getCommentById(Long id) {
		Optional<Comment> _comment = commentRepository.findById(id);
		Comment comment = null;
		if(_comment.isPresent()) {
			comment = _comment.get();
		}
		return comment;
	}

	@Override
	public Comment updateComment(Comment comment, Long id) {
		Optional<Comment> optComment = commentRepository.findById(id);
		Comment _comment = null;
		if(optComment.isPresent()) {
			_comment = optComment.get();
			_comment.setComment(comment.getComment());
		}
		return commentRepository.save(_comment);
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

}
