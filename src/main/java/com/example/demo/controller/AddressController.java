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

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping()
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping()
	public List<Address> getAddresses(){
		return addressService.getAddress();
	}
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id") long id) {
		return addressService.getAddressById(id);
	}
	
	@PutMapping("/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable("id") long id) {
		return addressService.updateAddress(address, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") long id) {
		addressService.deleteAddress(id);
		
		return new ResponseEntity<String>("Address deleted Successfully", HttpStatus.OK);
	}
	

}
