package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateRequest {
	
	private String username;
	private String password;
	
	public AuthenticateRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AuthenticateRequest() {
		super();
	}
	
	
	
	
	

}
