package com.niit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private int supid;
	
 private String supname;
 @OneToMany(mappedBy="supplier", cascade=CascadeType.ALL,fetch=FetchType.LAZY )
 private List<Product> products;
 
 private String address;
 
 public Supplier() {
	// TODO Auto-generated constructor stub
}
 
 public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Transient
 private MultipartFile image;
 
 public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public int getSupid() {
	return supid;
}
public void setSupid(int supid) {
	this.supid = supid;
}
public String getSupname() {
	return supname;
}
public void setSupname(String supname) {
	this.supname = supname;
}

}
