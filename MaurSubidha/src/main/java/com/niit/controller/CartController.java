package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Services.CustomerService;
import com.niit.model.Customer;

@Controller

public class CartController {
 
	@Autowired
    private CustomerService customerService;
	
	

    @RequestMapping("/all/cart")
    public String getCart(){
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = user.getUsername();
        Customer customer = customerService.getCustomerByUsername(username);
        int cartId = customer.getCart().getCartid();

        return "redirect:/all/cart/" + cartId;
    }

    @RequestMapping("/all/cart/{cartid}")
    public String getCartRedirect(@PathVariable (value = "cartid") int cartId, Model model){
        model.addAttribute("cartId", cartId);

        return "cart";
    }

} // The End of Class;
