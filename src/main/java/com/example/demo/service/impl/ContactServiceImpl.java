package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContactRepo;
import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	private ContactRepo contactRepository;
	
	
	public ContactServiceImpl(ContactRepo contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(long id) {
		return contactRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Contact Not Found"));
				
	}

	@Override
	public Contact updateContact(Contact contact, long id) {
		Contact _contact = contactRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Contact Not Found"));
		
		_contact.setEmail(contact.getEmail());
		_contact.setMobileNumber(contact.getMobileNumber());
		
		return contactRepository.save(_contact);
	}

	@Override
	public void deleteContact(long id) {
		contactRepository.deleteById(id);	
	}

}
