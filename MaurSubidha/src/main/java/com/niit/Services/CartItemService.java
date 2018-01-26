package com.niit.Services;


import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);	
	CartItem getCartItemByCartItem(int cartItemId);
	void removeCartItem(CartItem cartItem);

	
}
