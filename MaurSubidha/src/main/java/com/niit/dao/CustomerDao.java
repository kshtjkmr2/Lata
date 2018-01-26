package com.niit.dao;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerDao {

	void saveCustomer(Customer c);
	
	List<Customer> getCustomers();

	Customer getCustomerByUsername(String username);

	
}
