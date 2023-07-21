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

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@PostMapping()
	public Contact saveContact(@RequestBody Contact Contact) {
		return contactService.saveContact(Contact);
	}
	
	@GetMapping()
	public List<Contact> getContactes(){
		return contactService.getContacts();
	}
	
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable("id") long id) {
		return contactService.getContactById(id);
	}
	
	@PutMapping("/{id}")
	public Contact updateContact(@RequestBody Contact Contact, @PathVariable("id") long id) {
		return contactService.updateContact(Contact, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") long id) {
		contactService.deleteContact(id);
		
		return new ResponseEntity<String>("Contact deleted Successfully", HttpStatus.OK);
	}
}
