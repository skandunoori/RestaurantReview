package com.example.demo.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.Contact;

public interface ContactService {
	
	Contact saveContact(Contact contact);
	
	List<Contact> getContacts();
	
	Contact getContactById(long id);
	
	Contact updateContact(Contact contact, long id);
	
	void deleteContact(long id);

}
