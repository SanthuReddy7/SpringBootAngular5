package com.springBootApplication.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootApplication.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class WebController {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(1, new Customer(1, "sa", "Re", 24));
	       
	    }
	};
	
	@GetMapping(value="/customer")
	public List<Customer> getCustomers(){

		List<Customer> results = new ArrayList<Customer>(customers.values());
		return results;
	}
	
	@GetMapping(value="/customer/{id}")
	public Customer getCustomer(@PathVariable int id){
		return customers.get(id);
	}
	
	@PostMapping(value="/customer")
	public Customer postCustomer(@RequestBody Customer customer){
		int id = customers.size() + 1;
		customer.setId(id);
		customers.put(id, customer);
		return customer;
	}
	
	@PutMapping(value="/customer/{id}")
	public void putCustomer(@RequestBody Customer customer, @PathVariable int id){
		customers.replace(id, customer);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable int id){
		customers.remove(id);
	}
}