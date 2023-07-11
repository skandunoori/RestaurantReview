package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Menu {
	
	@Id
	private int menuId;
	private float price;
	private int calories;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int mid) {
		this.menuId = menuId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", price=" + price + ", calories=" + calories + "]";
	}
	
	

}
