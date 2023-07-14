package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;


public interface UserService {
	
	User saveUser(User user);
	 
	List<User> getUsers();
	
	Optional<User> getUserById(Long id);
	
	User updateUser(User user, Long id);
	
	void deleteUser(Long id);

}
