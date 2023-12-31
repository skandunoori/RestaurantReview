package com.example.demo.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Util.JWTUtil;
import com.example.demo.service.impl.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JwtOnePerRequestFilter is a Spring component used as a filter to intercept incoming HTTP requests and perform JWT authentication.
 * This class extends the OncePerRequestFilter, ensuring it's only executed once per request.
 */
@Component
public class JwtOnePerRequestFilter extends OncePerRequestFilter{

	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	/**
	 * Method to perform filtering for each incoming HTTP request.
	 * It intercepts the request, extracts the JWT token from the Authorization header, and performs JWT authentication.
	 * @param request The incoming HTTP request.
	 * @param response The HTTP response.
	 * @param filterChain The filter chain for processing the request and response.
	 * @throws ServletException If a servlet-specific error occurs during filtering.
	 * @throws IOException If an I/O error occurs during filtering.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		String jwt = null;
		String username = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			username = jwtUtil.extractUserName(jwt);
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
