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

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService menuService;

	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	@PostMapping("/restaurant/{restaurantId}")
	public Menu saveMenu(@RequestBody Menu menu, @PathVariable("restaurantId") long restaurantId) {
		return menuService.saveMenu(menu, restaurantId);
	}
	
	@GetMapping()
	public List<Menu> getMenu(){
		return menuService.getMenu();
	}
	
	@GetMapping("/{id}")
	public Menu getMenuById(@PathVariable("id") long id) {
		return menuService.getMenuById(id);
	}
	
	@PutMapping("/{id}")
	public Menu updateMenu(@RequestBody Menu menu, @PathVariable("id") long id) {
		return menuService.updateMenu(menu, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable("id") long id) {
		menuService.deleteMenu(id);
		
		return new ResponseEntity<String>("Menu deleted successfully", HttpStatus.OK);
	}

}
