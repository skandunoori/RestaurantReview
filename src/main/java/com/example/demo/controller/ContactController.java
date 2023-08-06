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

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

/**
 * Controller class for managing CRUD operations on Contact entities.
 */
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {
	
	private ContactService contactService;
	
	//Constructor to inject ContactService dependency
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	/**
	 * Create a new contact.
	 * 
	 * @param contact The Contact object containing contact details to be saved.
	 * @return The saved Contact object.
	 */
	@PostMapping()
	public Contact saveContact(@RequestBody Contact Contact) {
		return contactService.saveContact(Contact);
	}
	
	/**
	 * Get all contacts.
	 * 
	 * @return A list of all contacts in the database.
	 */
	@GetMapping()
	public List<Contact> getContactes(){
		return contactService.getContacts();
	}
	
	/**
	 * Get a contact by its ID.
	 * 
	 * @param id The ID of the contact to retrieve.
	 * @return The contact object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable("id") long id) {
		return contactService.getContactById(id);
	}
	
	/**
	 * Update an existing contact by its ID.
	 * 
	 * @param contact The Contact object containing updated contact details.
	 * @param id The ID of the contact to be updated.
	 * @return The updated Contact object.
	 */
	@PutMapping("/{id}")
	public Contact updateContact(@RequestBody Contact Contact, @PathVariable("id") long id) {
		return contactService.updateContact(Contact, id);
	}
	
	/**
	 * Delete a contact by its ID.
	 * 
	 * @param id The ID of the contact to be deleted.
	 * @return ResponseEntity with a success message or an error message if the contact is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") long id) {
		contactService.deleteContact(id);
		
		return new ResponseEntity<String>("Contact deleted Successfully", HttpStatus.OK);
	}
}
