package edu.sp5.javacafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.service.CustomerService;

@Controller("customerController")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/customer")
	public String customer() {
		return "input_test";
	}
	
	@PostMapping("/customer")
	public ModelAndView customerControll(@RequestParam("customerNumber") String customerNumber) {
		ModelAndView mav = new ModelAndView();
		Customer customer = customerService.findCustomerByCustomerNumber(customerNumber);
		if(customer == null) {
			customerService.addCustomer(new Customer(customerNumber, 0));
			customer = customerService.findCustomerByCustomerNumber(customerNumber);
		}
		mav.addObject("customer", customer);
		mav.setViewName("testpage");
		return mav;
	}
}
