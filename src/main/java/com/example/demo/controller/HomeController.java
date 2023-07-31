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

/**
 * This class represents a REST controller for handling endpoints related to user authentications.
 */
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
	
	/**
     * Endpoint to handle user authentication and generate a JWT token upon successful authentication.
     * @param request An AuthenticateRequest object containing the user's credentials (username and password).
     * @return A ResponseEntity containing an AuthenticateResponse object with the generated JWT token.
     * @throws Exception If an exception occurs during the authentication process.
     */
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticateResponse> createAndAuthenticateReq(@RequestBody AuthenticateRequest request) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}
		catch(Exception e) {
			throw new Exception("Invalid username or password"+e);
		}
		
		String username = request.getUsername();
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		String jwtToken = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwtToken));
	}

}
