package com.niit.Services;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {

	void saveCustomer(Customer c);

	List<Customer> getCustomers();

	Customer getCustomerByUsername(String username);

	

	
	
}
