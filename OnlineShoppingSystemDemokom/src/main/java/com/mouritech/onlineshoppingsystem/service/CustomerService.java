package com.mouritech.onlineshoppingsystem.service;

import java.util.List;

import com.mouritech.onlineshoppingsystem.entity.Customer;
import com.mouritech.onlineshoppingsystem.exception.CustomerNotFoundException;

public interface CustomerService {
	Customer insertCustomer(Customer newCustomer);

	Customer showCustById(String CustId) throws CustomerNotFoundException;

	List<Customer> showAllCustomers();



	Customer updateCustById(String CustId, Customer Customer) throws CustomerNotFoundException;

	void deleteCustById(String CustId) throws CustomerNotFoundException;
}
