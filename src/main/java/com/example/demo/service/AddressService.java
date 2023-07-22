package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Address;

/**
 * The Address Service interface defines the methods for managing CRUD operations on Address entities.
 * It provides methods to create, read, update, and delete addresses in the system.
 */
public interface AddressService {
	
	/**
	 * Create a new address in the database.
	 * 
	 * @param address The Address object to be saved.
	 * @return The saved Address object.
	 */
	Address saveAddress(Address address);
	
	/**
	 * Get all addresses from the database.
	 * 
	 * @return A list containing all addresses stored in the database.
	 */
	List<Address> getAddress();
	
	/**
	 * Get an address by its ID from the database.
	 * 
	 * @param id The ID of the address to retrieve.
	 * @return The Address object with the specified ID, or null if not found.
	 */
	Address getAddressById(long id);
	
	/**
	 * Update an existing address in the database.
	 * 
	 * @param address The Address object containing updated address details.
	 * @param id The ID of the address to be updated.
	 * @return The updated Address object.
	 */
	Address updateAddress(Address address, long id);
	
	/**
	 * Delete an address from the database.
	 * 
	 * @param id The ID of the address to be deleted.
	 */
	void deleteAddress(long id);
	
}
