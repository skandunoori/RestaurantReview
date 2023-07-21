package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restuarant_id")
	private long restuarantId;
	@Nonnull
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private Contact contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval=true)
//	@JsonIgnore
	private Set<Rating> ratings = new HashSet<>();
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval=true)
//	@JsonIgnore
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "restaurant_id", referencedColumnName = "restuarant_id")
	private Set<Menu> menu = new HashSet<>();
	

}
