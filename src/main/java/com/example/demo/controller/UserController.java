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

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping()
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping()
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long id) throws NotFoundException {
		return userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") long id) throws NotFoundException {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}

}
