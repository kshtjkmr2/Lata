package com.niit.Services;

import com.niit.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);

	double getCustomerOrderGrandTotal(int cartId);
}
