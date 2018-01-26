package com.niit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
private int customerid;
    
@NotNull(message="first name is mandatory")
private String firstname;   
private String lastname;

@Column(unique=true,nullable=false)
@NotNull(message="Email is mandatory")
@Email
private String email;

@Digits(fraction = 0, integer = 10)
@NotNull(message="Phone No is mandatory")
private String phone;
  
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userid")
@JsonIgnore
private Users users; 
   
@OneToOne(cascade=CascadeType.ALL) 
@JoinColumn(name="billingid")
@JsonIgnore
private BillingAddress billingAddress;
   
@OneToOne(cascade=CascadeType.ALL) 
@JoinColumn(name="shippingid")
@JsonIgnore
private ShippingAddress shippingAddress;
   
@OneToOne(cascade=CascadeType.ALL) 
@JoinColumn(name="cartid")
@JsonIgnore
private Cart cart;
 
public Customer() {
	// TODO Auto-generated constructor stub
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
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
public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
