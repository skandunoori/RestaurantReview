package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Contact;

/**
 * The Contact Service interface defines the methods for managing CRUD operations on Contact entities.
 * It provides methods to create, read, update, and delete contacts in the system.
 */
public interface ContactService {
	
	/**
	 * Create a new contact in the database.
	 * 
	 * @param contact The Contact object to be saved.
	 * @return The saved Contact object.
	 */
	Contact saveContact(Contact contact);
	
	/**
	 * Get all contacts from the database.
	 * 
	 * @return A list containing all contacts stored in the database.
	 */
	List<Contact> getContacts();
	
	/**
	 * Get a contact by its ID from the database.
	 * 
	 * @param id The ID of the contact to retrieve.
	 * @return The Contact object with the specified ID, or null if not found.
	 */
	Contact getContactById(long id);
	
	/**
	 * Update an existing contact in the database.
	 * 
	 * @param contact The Contact object containing updated contact details.
	 * @param id The ID of the contact to be updated.
	 * @return The updated contact object.
	 */
	Contact updateContact(Contact contact, long id);
	
	/**
	 * Delete a contact from the database.
	 * 
	 * @param id The ID of the contact to be deleted.
	 */
	void deleteContact(long id);

}
