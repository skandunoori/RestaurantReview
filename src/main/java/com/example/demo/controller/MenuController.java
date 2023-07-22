package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;

/**
 * Controller class for managing CRUD operations on Menu entities.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService menuService;
	
	//Constructor to inject MenuService dependency
	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	/**
	 * Create a new menu.
	 * 
	 * @param menu The Menu object containing menu details to be saved.
	 * @param restaurantId The Id of the restaurant the menu belongs to.
	 * @return The saved menu object.
	 */
	@PostMapping("/restaurant/{restaurantId}")
	public Menu saveMenu(@RequestBody Menu menu, @PathVariable("restaurantId") long restaurantId) {
		return menuService.saveMenu(menu, restaurantId);
	}
	
	/**
	 * Get all menu.
	 * 
	 * @return A list of all menu in the database.
	 */
	@GetMapping()
	public List<Menu> getMenu(){
		return menuService.getMenu();
	}
	
	/**
	 * Get menu by its ID.
	 * 
	 * @param id The ID of the menu to retrieve.
	 * @return The Menu object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Menu getMenuById(@PathVariable("id") long id) {
		return menuService.getMenuById(id);
	}
	
	/**
	 * Update an existing menu by its ID.
	 * 
	 * @param menu The Menu object containing updated menu details.
	 * @param id The ID of the menu to be updated.
	 * @return The updated menu object.
	 */
	@PutMapping("/{id}")
	public Menu updateMenu(@RequestBody Menu menu, @PathVariable("id") long id) {
		return menuService.updateMenu(menu, id);
	}
	
	/**
	 * Delete a menu by its ID.
	 * 
	 * @param id The ID of the menu to be deleted.
	 * @return ResponseEntity with a success message or an error message if the menu is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable("id") long id) {
		menuService.deleteMenu(id);
		
		return new ResponseEntity<String>("Menu deleted successfully", HttpStatus.OK);
	}

}
