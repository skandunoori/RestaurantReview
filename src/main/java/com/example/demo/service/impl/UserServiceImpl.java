package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * Class that implements UserService interface
 */
@Service
public class UserServiceImpl implements UserService{
	
	
	private UserRepo userRepository;

	public UserServiceImpl(UserRepo userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found."));
	}

	@Override
	public User updateUser(User user, Long id) {
		User _user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found to update."));
		
		_user.setFirst_name(user.getFirst_name());
		_user.setLast_name(user.getLast_name());
		_user.setGender(user.getGender());
		_user.setBirth_date(user.getBirth_date());
		
		return userRepository.save(_user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("UserName not found!"));
	}
//
//	@Override
//	public User findByPassword(String password) {
//		return userRepository.findByPassword(password);
//	}

}
