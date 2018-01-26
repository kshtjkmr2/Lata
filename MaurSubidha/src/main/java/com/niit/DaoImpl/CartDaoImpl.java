package com.niit.DaoImpl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Services.CustomerOrderService;
import com.niit.Services.CustomerService;
import com.niit.dao.CartDao;
import com.niit.model.Cart;
@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CustomerOrderService customerOrderService;
	
	public Cart getCartById(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart) session.get(Cart.class,cartId);
		session.flush();
		session.close();
		return cart;
	}
	 public void update(Cart cart){
	        int cartId = cart.getCartid();
	        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
	        cart.setGrandTotal(grandTotal);

	        Session session = sessionFactory.openSession();
	        session.saveOrUpdate(cart);
	        session.flush();
	        session.close();
	    }

	    public Cart validate(int cartId) throws IOException{
	        Cart cart = getCartById(cartId);
	        if(cart == null || cart.getCartItems().size() == 0){
	            throw new IOException(cartId + "");
	            
	        }

	        update(cart);
	        return cart;
	    }

}
