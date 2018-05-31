package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItem cartItem) {	
		        Session session = sessionFactory.openSession();
		        session.saveOrUpdate(cartItem);
		        session.flush();
		        session.close();
		    }
	
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            removeCartItem(item);
        }
		
	}

	public CartItem getCartItemByCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
        Query query = session.createQuery("from CartItem where cartItemid = ?");
        query.setInteger(0, cartItemId);
        CartItem item=(CartItem) query.uniqueResult();
        session.flush();
        //session.close();
        return item;
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
        session.delete(cartItem);
        session.flush();
        session.close();
		
	}
	
}

