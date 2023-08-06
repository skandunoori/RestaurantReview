package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRepo;
import com.example.demo.dao.RestaurantRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Address;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.AddressService;

/**
 * Class that implements AddressService interface
 */
@Service
public class AddressServiceImpl implements AddressService{
	
	private AddressRepo addressRepository;
	private RestaurantRepo restaurantRepository;
	private UserRepo userRepository;
	
	
	public AddressServiceImpl(AddressRepo addressRepository, RestaurantRepo restaurantRepository, UserRepo userRepository) {
		super();
		this.addressRepository = addressRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Address saveRestaurantAddress(Address address, long restaurantId) {
		
		Restaurant _restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
				() -> new ResourceNotFoundException("Restaurant Not Found"));
		
		Address previousAddress = _restaurant.getAddress();
		
		if(_restaurant != null) {
			addressRepository.delete(previousAddress);
		}
		Address updatedAddress = addressRepository.save(address);
		_restaurant.setAddress(updatedAddress);
		restaurantRepository.save(_restaurant);
		
		return addressRepository.save(address);
	}
	
	@Override
	public Address saveUserAddress(Address address, long userId) {
		
		User _user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User not found"));
		
		Address previousAddress = _user.getAddress();
		
		if(_user != null) {
			addressRepository.delete(previousAddress);
		}
		Address updatedAddress = addressRepository.save(address);
		_user.setAddress(updatedAddress);
		userRepository.save(_user);
		
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
