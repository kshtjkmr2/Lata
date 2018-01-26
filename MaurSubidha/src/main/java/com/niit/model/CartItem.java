package com.niit.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem implements Serializable{
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int cartItemid;
private int quantity;
private double totalPrice;
    
@ManyToOne
@JoinColumn(name = "cartid")
@JsonIgnore
private Cart cart;

@ManyToOne
@JoinColumn(name = "productid")
private Product product;

public CartItem() {
	// TODO Auto-generated constructor stub
}    
    
	public int getCartItemid() {
		return cartItemid;
	}

	public void setCartItemid(int cartItemid) {
		this.cartItemid = cartItemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}   
}
