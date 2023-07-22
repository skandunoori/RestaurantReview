package com.example.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The Address class represents a address entity in the application.
 */
@Entity
@Getter
@Setter
@Table(name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long addressId;
	@Nonnull
	private String street;
	private String apt;
	@Nonnull
	private String city;
	@Nonnull
	private String state;
	@Nonnull
	private String country;
	@Nonnull
	private String zipCode;
	

}
