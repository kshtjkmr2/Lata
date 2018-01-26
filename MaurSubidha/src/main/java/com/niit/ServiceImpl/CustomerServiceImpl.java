package com.niit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Services.CustomerService;
import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerDao customerDao;
	public void saveCustomer(Customer c) {
		customerDao.saveCustomer(c);
		
	}
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}
	public Customer getCustomerByUsername(String username) {
		
		return customerDao.getCustomerByUsername( username);
	}

}
