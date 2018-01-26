package com.niit.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int orderid;
	
@OneToOne
@JoinColumn(name = "cartid")
private Cart cart;
	 
@OneToOne
@JoinColumn(name = "customerid")
private Customer customer;

@OneToOne
@JoinColumn(name = "billingid")
private BillingAddress billingAddress;

@OneToOne
@JoinColumn(name="shipppingid")
private ShippingAddress shippingAddress;

public CustomerOrder() {
	// TODO Auto-generated constructor stub
}		

		public Cart getCart() {
			return cart;
		}

		public int getOrderid() {
			return orderid;
		}

		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public BillingAddress getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}

		public ShippingAddress getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(ShippingAddress shippingAddress) {
			this.shippingAddress = shippingAddress;
		}
}
