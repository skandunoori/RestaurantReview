package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Food {
	
	@Id
	private int foodId;
	private String name;
	List<String> ingredients;
	//cuisine variable - enum?
	
	public String getName() {
		return name;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", ingredients=" + ingredients + "]";
	}
	
	

}
