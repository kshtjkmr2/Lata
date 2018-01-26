package com.niit.dao;


import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByCartItem(int cartItemId);
	void removeCartItem(CartItem cartItem);

}
