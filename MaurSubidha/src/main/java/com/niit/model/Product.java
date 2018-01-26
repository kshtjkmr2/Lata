package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int productid;	
private String name;	
private String manufacturer;	
private double price;	
private int unitInStock;	
private String description;

@ManyToOne
@JoinColumn(name="supid")
@JsonIgnore
private Supplier supplier;

@ManyToOne
@JoinColumn(name="cid")
@JsonIgnore
private Category category;

@Transient
private MultipartFile image;

public Product() {
	// TODO Auto-generated constructor stub
}

public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}

public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getUnitInStock() {
	return unitInStock;
}
public void setUnitInStock(int unitInStock) {
	this.unitInStock = unitInStock;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

}
