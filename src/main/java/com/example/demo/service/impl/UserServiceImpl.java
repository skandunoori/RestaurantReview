package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	private UserRepo userRepository;

	public UserServiceImpl(UserRepo userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) throws NotFoundException {
		return userRepository.findById(id).orElseThrow(
				() -> new NotFoundException());
	}

	@Override
	public User updateUser(User user, Long id) throws NotFoundException {
		User _user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found"));
		
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

}