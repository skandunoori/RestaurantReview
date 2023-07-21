package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MenuRepo;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.model.Menu;
import com.example.demo.model.Restaurant;
import com.example.demo.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	private MenuRepo menuRepository;
	
	private RestaurantRepo restaurantRepository;

	public MenuServiceImpl(MenuRepo menuRepository, RestaurantRepo restaurantRepository) {
		super();
		this.menuRepository = menuRepository;
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Menu saveMenu(Menu menu, long restaurantId) {
		Menu _menu = menuRepository.save(menu);
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
				() -> new ResourceNotFoundException("Restaurant Not Found"));
		
		_menu.setRestaurant(restaurant);
		restaurant.getMenu().add(_menu);
		restaurantRepository.save(restaurant);
		
		return menuRepository.save(_menu);
	}

	@Override
	public List<Menu> getMenu() {
		return menuRepository.findAll();
	}

	@Override
	public Menu getMenuById(long id) {
		return menuRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Menu not found"));
	}

	@Override
	public Menu updateMenu(Menu menu, long id) {
		Menu _menu = menuRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Menu Not Found"));
		
		_menu.setPrice(menu.getPrice());
		_menu.setCalories(menu.getCalories());
		
		return menuRepository.save(_menu);
	}

	@Override
	public void deleteMenu(long id) {
		menuRepository.deleteById(id);
	}

}
