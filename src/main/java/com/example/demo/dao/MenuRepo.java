package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Menu;

public interface MenuRepo extends JpaRepository<Menu, Long>{

}
