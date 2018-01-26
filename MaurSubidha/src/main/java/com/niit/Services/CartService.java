package com.niit.Services;

import java.io.IOException;

import com.niit.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
