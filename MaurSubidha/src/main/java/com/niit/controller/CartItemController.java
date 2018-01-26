package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.Services.CartItemService;
import com.niit.Services.CartService;
import com.niit.Services.CustomerService;
import com.niit.Services.ProductService;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartItemController {
	
	@Autowired
    private CartService cartService;
	
	@Autowired
    private CartItemService cartItemService;
	
	@Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;
    
    @RequestMapping("/{cartid}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartid") int cartId){
        return cartService.getCartById(cartId);
    }
    
    @RequestMapping(value = "/add/{productid}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "productid") int productId){      
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getProductid() == cartItems.get(i).getProduct().getProductid()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }
    
    @RequestMapping(value = "/remove/{cartItemId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "cartItemid") int cartItemId){
    	System.out.println("Inside cartitemcontroller");
        CartItem cartItem = cartItemService.getCartItemByCartItem(cartItemId);
        cartItemService.removeCartItem(cartItem);

    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartid") int cartid){
    	
        Cart cart = cartService.getCartById(cartid);
        cartItemService.removeAllCartItems(cart);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

    }
	
} 
