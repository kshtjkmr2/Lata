package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.niit.dao.CustomerDao;
import com.niit.model.Authorities;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.Users;

@Repository
public class CustomerDaoImpl implements CustomerDao {
@Autowired
private SessionFactory sessionFactory;
	public void saveCustomer(Customer c) {
		Users users=c.getUsers();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		users.setPassword(encoder.encode(users.getPassword()));
		users.setEnabled(true);
		
		Authorities authorities=new Authorities();
		authorities.setUsername(users.getUsername());
		authorities.setRole("ROLE_USER");
		
		Session session= sessionFactory.openSession();
		session.save(authorities);
		
		Cart cart=new Cart();
		cart.setCustomer(c);
		c.setCart(cart);
		session.save(c);
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
	}
	public List<Customer> getCustomers(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer");
		List<Customer> customers=query.list();
		session.close();
		return customers;
		
	}
	public Customer getCustomerByUsername(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Users where username=? ");
		query.setString(0, username);
		Users users=(Users)query.uniqueResult();
		Customer customers=users.getCustomer();
		session.close();
		return customers;
	}

}
