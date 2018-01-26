package com.niit.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Services.CategoryService;
import com.niit.Services.SupplierService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SupplierService supplierService;
	
    @RequestMapping(value={"/","home"}) 
    public String homepage(HttpSession session){
    	session.setAttribute("categories",categoryService.getAllCategories());
    	session.setAttribute("suppliers",supplierService.getAllSuppliers());
    	return "home";
    }
    @RequestMapping("/about")
    public String aboutUs()
    {
    	return "about";
    }
    @RequestMapping("/login")
    public String login(@RequestParam(value="error",required=false)String error,
    		@RequestParam(value="logout",required=false) String logout,Model model){
    	if(error!=null)
    		model.addAttribute("error", "Invalid Username and password");
    	if(logout!=null)
    		model.addAttribute("logout","Logout Successful");
				return "loginform";	
    }
}
