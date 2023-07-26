package com.example.demo.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
//	@Autowired
//	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
//		com.example.demo.model.User user = userService.findByUsername(username);
//		System.out.println(user.getUsername());
		
//		if(user != null) {
			return new org.springframework.security.core.userdetails.User("sanjana", passwordEncoder.encode("sanjana123"), new HashSet<GrantedAuthority>());
//		} else {
//			throw new ResourceNotFoundException("Invalid Username or password.");
//		}

	}

}
