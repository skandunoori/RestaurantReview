package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Menu;

/**
 * The Menu Service interface defines the methods for managing CRUD operations on menu entities.
 * It provides methods to create, read, update, and delete menu in the system.
 */
public interface MenuService {
	
	/**
	 * Create a new menu in the database.
	 * 
	 * @param menu The menu object to be saved.
	 * @param restaurantId The Id of the restaurant the menu belongs to.
	 * @return The saved menu object.
	 */
	Menu saveMenu(Menu menu, long restaurantId);
	
	/**
	 * Get all menu from the database.
	 * 
	 * @return A list containing all menu stored in the database.
	 */
	List<Menu> getMenu();
	
	/**
	 * Get a menu by its ID from the database.
	 * 
	 * @param id The ID of the menu to retrieve.
	 * @return The menu object with the specified ID, or null if not found.
	 */
	Menu getMenuById(long id);
	
	/**
	 * Update an existing menu in the database.
	 * 
	 * @param menu The menu object containing updated menu details.
	 * @param id The ID of the menu to be updated.
	 * @return The updated menu object.
	 */
	Menu updateMenu(Menu menu, long id);
	
	/**
	 * Delete a menu from the database.
	 * 
	 * @param id The ID of the menu to be deleted.
	 */
	void deleteMenu(long id);

}
