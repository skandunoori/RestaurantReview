package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The Comment class represents a comment entity in the application.
 */
@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id")
	private long commentId;
	@Nonnull
	private String comment;
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
}
