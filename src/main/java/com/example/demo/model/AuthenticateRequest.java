package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Thus class represents request object used for user authentication.
 * It is designed to hold the username and password provided by the user when attempting to authenticate. 
 */
@Getter
@Setter
public class AuthenticateRequest {
	
	private String username;
	private String password;
	
	/**
     * Constructor for creating an AuthenticateRequest object with provided username and password.
     * @param username The username provided by the user during authentication.
     * @param password The password provided by the user during authentication.
     */
	public AuthenticateRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
     * Default constructor for AuthenticateRequest class.
     * This constructor is required for deserialization purposes.
     */
	public AuthenticateRequest() {
		super();
	}
	
	
	
	
	

}
