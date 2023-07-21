package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Address;

public interface AddressService {
	
	Address saveAddress(Address address);
	
	List<Address> getAddress();
	
	Address getAddressById(long id);
	
	Address updateAddress(Address address, long id);
	
	void deleteAddress(long id);
	
}
