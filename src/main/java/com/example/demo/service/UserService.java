package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

/**
 * The User Service interface defines the methods for managing CRUD operations on user entities.
 * It provides methods to create, read, update, and delete users in the system.
 */
public interface UserService {
	
	/**
	 * Create a new user in the database.
	 * 
	 * @param user The user object to be saved.
	 * @return The saved user object.
	 */
	User saveUser(User user);
	 
	/**
	 * Get all users from the database.
	 * 
	 * @return A list containing all users stored in the database.
	 */
	List<User> getUsers();
	
	/**
	 * Get a user by its ID from the database.
	 * 
	 * @param id The ID of the user to retrieve.
	 * @return The user object with the specified ID, or null if not found.
	 */
	User getUserById(Long id);
	
	/**
	 * Update an existing user in the database.
	 * 
	 * @param user The user object containing updated user details.
	 * @param id The ID of the user to be updated.
	 * @return The updated user object.
	 */
	User updateUser(User user, Long id);
	
	/**
	 * Delete a user from the database.
	 * 
	 * @param id The ID of the user to be deleted.
	 */
	void deleteUser(Long id);
	
	User findByUsername(String username);
	
	User findByPassword(String password);

}
