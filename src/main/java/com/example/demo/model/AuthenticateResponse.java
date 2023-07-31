package com.example.demo.model;

/**
 * This class represents the response object for user authentication.
 * It is used to encapsulate the JSON Web Token (JWT) generated upon successful authentication.
 */
public class AuthenticateResponse {
	
	private final String jwtToken;

	/**
     * Constructor for creating an AuthenticateResponse object with the JWT token.
     * @param jwtToken The JSON Web Token (JWT) generated upon successful authentication.
     */
	public AuthenticateResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
	

}
