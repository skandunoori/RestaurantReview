package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Menu;

public interface MenuService {
	
	Menu saveMenu(Menu menu, long restaurantId);
	
	List<Menu> getMenu();
	
	Menu getMenuById(long id);
	
	Menu updateMenu(Menu menu, long id);
	
	void deleteMenu(long id);

}
