package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The Menu class represents a menu entity in the application.
 */
@Entity
@Getter
@Setter
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	private long menuId;
	@Nonnull
	private float price;
	private float calories;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_food_id")
	private Food food;
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;
	
}
