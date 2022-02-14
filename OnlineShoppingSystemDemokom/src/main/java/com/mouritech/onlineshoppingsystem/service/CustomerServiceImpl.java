package com.mouritech.onlineshoppingsystem.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlineshoppingsystem.entity.Customer;
import com.mouritech.onlineshoppingsystem.exception.CustomerNotFoundException;
import com.mouritech.onlineshoppingsystem.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository CustomerRepository;

	@Override
	public Customer insertCustomer(Customer newCustomer) {
	
		newCustomer.setCustId(generateCustId());
		return CustomerRepository.save(newCustomer);
	}
	
	
	public String generateCustId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long cId = (long) rand.nextInt(upperbound);
		return "C00" + cId; 
	
	}


	@Override
	public Customer showCustById(String CustId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return CustomerRepository.findByCustId(CustId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + CustId));
	}


	@Override
	public List<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		return CustomerRepository.findAll();
	}


	@Override
	public Customer updateCustById(String CustId,Customer Customer) throws CustomerNotFoundException {
		Customer existingCustomer = CustomerRepository.findByCustId(CustId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + CustId));
		existingCustomer.setCustName(Customer.getCustName());
		existingCustomer.setCustAddress(Customer.getCustAddress());
		existingCustomer.setCustEmail(Customer.getCustEmail());
		existingCustomer.setCustPhn(Customer.getCustPhn());
		CustomerRepository.save(existingCustomer);
		return existingCustomer;
	}


	@Override
	public void deleteCustById(String CustId) throws CustomerNotFoundException {
		Customer existingCustomer = CustomerRepository.findByCustId(CustId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + CustId));
		CustomerRepository.delete(existingCustomer);
	}

}
