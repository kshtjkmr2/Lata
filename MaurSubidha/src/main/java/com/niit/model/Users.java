package com.niit.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int userid;
	@Column(unique=true,nullable=false)
	@NotEmpty
private String username;
	@NotEmpty
private String password;
	
private boolean enabled;
   @OneToOne(mappedBy="users",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private Customer customer;

public Users() {
	// TODO Auto-generated constructor stub
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

}
 