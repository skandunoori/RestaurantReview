package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return repo.save(user);
	}

}
