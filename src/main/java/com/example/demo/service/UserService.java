package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.User;


public interface UserService {
	
	User saveUser(User user);
	 
	List<User> getUsers();
	
	User getUserById(Long id) throws NotFoundException;
	
	User updateUser(User user, Long id) throws NotFoundException;
	
	void deleteUser(Long id);

}
