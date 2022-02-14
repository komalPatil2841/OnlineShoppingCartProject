package com.mouritech.onlineshoppingsystem.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlineshoppingsystem.exception.CustomerNotFoundException;
import com.mouritech.onlineshoppingsystem.entity.Customer;
import com.mouritech.onlineshoppingsystem.service.CustomerService;

@RestController// (@Controller + @ResponseBody)

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CustomerController {



	@Autowired
	CustomerService customerService;
	
	@PostMapping("customer")
	public Customer insertCustomer(@RequestBody Customer newCustomer) {
		
		return customerService.insertCustomer(newCustomer);
		
	}
	
	@GetMapping("customer")
	public List<Customer> showAllCustomers(){
		return customerService.showAllCustomers();
		
	}
	
	@GetMapping("customer/{cid}")
	public Customer showCustomerById(@PathVariable("cid") String custId) throws CustomerNotFoundException{
		return customerService.showCustById(custId);
		
	}
	
	@PutMapping("customer/{cid}")
	public Customer updateCustomerById(@PathVariable("cid") String custId,@RequestBody Customer customer) throws CustomerNotFoundException{
		return customerService.updateCustById(custId,customer);
		
	}
	
	@DeleteMapping("customer/{cid}")
	public String deleteCustomerById(@PathVariable("cid") String custId) throws CustomerNotFoundException{
		 customerService.deleteCustById(custId);
		 return "deleted the customer";
		
	}
	
	
	
	
}
