package com.niit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Services.CustomerService;
import com.niit.model.Customer;

@Controller
public class CustomerController {
@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/all/registrationform")
	public String getRegistrationForm(Model model){
		model.addAttribute("customer",new Customer());
		return "registrationform";
	}
	@RequestMapping(value="/all/register", method=RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute("customer") Customer c,Model model,BindingResult result){
		if(result.hasErrors()){
		return "redirect:/all/registrationform";
		}
		List<Customer> customers=customerService.getCustomers();
		String username=c.getUsers().getUsername();
		String email=c.getEmail();
		for(Customer customer:customers){
			if(customer.getUsers().getUsername().equals(username))
			{
				model.addAttribute("duplicateusername","Username Already Exist");
				return "registrationform";
			}
		}
			for(Customer customer:customers){
				if(customer.getEmail().equals(email))
				{
					model.addAttribute("duplicateemail","Email Already Exist");
					return "registrationform";
				}	
		}
		
		customerService.saveCustomer(c);
		model.addAttribute("registrationSuccess","Registration Successful...please login...");
		return "/loginform";
	}
}
