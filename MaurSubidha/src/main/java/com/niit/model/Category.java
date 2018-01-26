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

@Entity
public class Category implements Serializable{
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int cid;
	 
	 public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	private String categoryDetails;
	 @OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 private List<Product> products;
	 
 public Category() {
	// TODO Auto-generated constructor stub
}
	public String getCategoryDetails() {
		return categoryDetails;
	}
	public void setCategoryDetails(String categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
