package com.example.demo.service.impl;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRepo;
import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	private AddressRepo addressRepository;
	
	
	public AddressServiceImpl(AddressRepo addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(long id) {
		return addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Address not found"));
	}

	@Override
	public Address updateAddress(Address address, long id) {
		
		Address _address = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Address not found to update"));
		
		_address.setStreet(address.getStreet());
		_address.setApt(address.getApt());
		_address.setCity(address.getCity());
		_address.setState(address.getState());
		_address.setCountry(address.getCountry());
		_address.setZipCode(address.getZipCode());
		
		return addressRepository.save(_address);
	}

	@Override
	public void deleteAddress(long id) {
		addressRepository.deleteById(id);
	}

}
