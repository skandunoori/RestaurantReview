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
 * The Rating class represents a rating entity in the application.
 */
@Entity
@Getter
@Setter
@Table(name = "ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_id")
	private long ratingId;
	@Nonnull
	private int value; //will this be enum?
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
}
