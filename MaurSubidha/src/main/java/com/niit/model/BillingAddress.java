package com.niit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class BillingAddress implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int billingid;
private String apartmentnumber;
private String streetname;
private String city;
private String state;
private String country;
private String zipcode;

@OneToOne(cascade=CascadeType.ALL) 
@JoinColumn(name="customerid")
@JsonIgnore
private Customer customer;

public BillingAddress() {
	// TODO Auto-generated constructor stub
}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getBillingid() {
		return billingid;
	}
	public void setBillingid(int billingid) {
		this.billingid = billingid;
	}
public String getApartmentnumber() {
	return apartmentnumber;
}
public void setApartmentnumber(String apartmentnumber) {
	this.apartmentnumber = apartmentnumber;
}
public String getStreetname() {
	return streetname;
}
public void setStreetname(String streetname) {
	this.streetname = streetname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
}
