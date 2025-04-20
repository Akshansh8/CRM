package com.akshansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshansh.model.CustomerInfo;
import com.akshansh.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@GetMapping("/list")
	public String getAllCustomers(Model model) {
		List<CustomerInfo> customerInfos = service.getAllCustomer();
		model.addAttribute("customers", customerInfos);
		System.out.println("In list");
		return "listCustomers";
	}
	
	@GetMapping("/showForm")
	public String showForm(@ModelAttribute("customer") CustomerInfo customer)
	{
//		CustomerInfo customerInfo = new CustomerInfo();
//		System.out.println("In show form");
//		model.addAttribute("customer", customerInfo);
		return "showForm";
	}
	
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute("customer") CustomerInfo customer)
	{
		System.out.println("In register");
		service.registerCustomer(customer);
		return "redirect:/list";
	}
	
	@PostMapping("/update")
	public String updateCustomer(@RequestParam("customerId")Integer id, Model model)
	{
		CustomerInfo customerInfo = service.getCustomer(id);
		System.out.println("In update");
		model.addAttribute("customer", customerInfo);
		return "showForm";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")Integer id)
	{
		service.deleteCustomer(id);
		return "redirect:/list";
	}

}
