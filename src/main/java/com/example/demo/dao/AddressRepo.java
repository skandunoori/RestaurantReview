package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Address;

/**
 * AddressRepo is a Data Access Object (DAO) that extends the JpaRepository interface.
 * It provides pre-defined methods for interacting with the underlying database to perform CRUD operations on Address entities.
 */
public interface AddressRepo extends JpaRepository<Address, Long>{

}
