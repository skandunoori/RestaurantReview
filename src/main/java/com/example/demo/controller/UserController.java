package com.example.demo.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * Controller class for managing CRUD operations on User entities.
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	//Constructor to inject UserService dependency
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/**
	 * Create a new user.
	 * 
	 * @param user The User object containing user details to be saved.
	 * @return The saved user object.
	 */
	@PostMapping()
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	/**
	 * Get all users.
	 * 
	 * @return A list of all users in the database.
	 */
	@GetMapping()
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	/**
	 * Get a user by its ID.
	 * 
	 * @param id The Id of the user to retrieve.
	 * @return The user object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long id) throws NotFoundException {
		return userService.getUserById(id);
	}
	
	/**
	 * Update an existing user by its ID.
	 * 
	 * @param user The User object containing updated user details.
	 * @param id The ID of the user to be updated.
	 * @return The updated user object.
	 */
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") long id) throws NotFoundException {
		return userService.updateUser(user, id);
	}
	
	/**
	 * Delete a user by its ID.
	 * 
	 * @param id The ID of the user to be deleted.
	 * @return ResponseEntity with a success message or an error message if the user is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}

}
