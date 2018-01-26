package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Authorities implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int authoritiesid;

@Column(unique=true,nullable=false)
@NotEmpty
private String username;
@NotEmpty
private String role;
public Authorities() {
	
}
public int getAuthoritiesid() {
	return authoritiesid;
}
public void setAuthoritiesid(int authoritiesid) {
	this.authoritiesid = authoritiesid;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
