package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.JWTUtil;
import com.example.demo.model.AuthenticateRequest;
import com.example.demo.model.AuthenticateResponse;
import com.example.demo.service.impl.CustomUserDetailsService;

@RestController
public class HomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to this application";
	}
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticateResponse> createAndAuthenticateReq(@RequestBody AuthenticateRequest request) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}
		catch(Exception e) {
			throw new Exception("Invalid username or password");
		}
		
		String username = request.getUsername();
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		String jwtToken = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwtToken));
	}

}
