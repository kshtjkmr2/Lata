package com.niit.ServiceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Services.CartService;
import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Service
public class CartServiceImpl implements CartService {
@Autowired
private CartDao cartDao;

	public Cart getCartById(int cartId) {	
		return cartDao.getCartById(cartId);
	}

	public Cart validate(int cartId) throws IOException {
		
		return cartDao.validate(cartId);
	}

	public void update(Cart cart) {
		cartDao.update(cart);
		
	}

}
