package edu.sp5.javacafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Order;
import edu.sp5.javacafe.service.CustomerService;
import edu.sp5.javacafe.service.OrderService;
import edu.sp5.javacafe.util.OrderNumber;
import edu.sp5.javacafe.util.ReceiptNumberGenerator;

@Controller("paymentController")
public class PaymentController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("finalPayment")
	public ModelAndView finalPayment(@ModelAttribute Customer customer, @SessionAttribute("orderList") List<Order> orderList) {
		ModelAndView mav = new ModelAndView();
		long receiptNumber = ReceiptNumberGenerator.getReceiptNumber();
		long orderNumber = OrderNumber.getOrderNumber();
		long totalOrderQuantity = 0;
		
		for(Order order : orderList) {
			order.setReceiptNumber(receiptNumber);
			order.setOrderNumber(orderNumber);
			orderService.addOrder(order);
			if(!order.getPaymentMethod().equals("Free")) {
				totalOrderQuantity += order.getOrderQuantity();
			}
		}
		customerService.updateMileage(customer, totalOrderQuantity);
		
		mav.setViewName("receipt");
		return mav;
	}
	
	@PostMapping("finalPayment")
	public ModelAndView finalPayment(@SessionAttribute("orderList") List<Order> orderList, @RequestParam("paymentMethod") String paymentMethod, @RequestParam("customerNumber") String customerNumber) {
		ModelAndView mav = new ModelAndView();
		String warningMsg = null;
		double totalPrice = 0;
		
		Customer customer = customerService.findCustomerByCustomerNumber(customerNumber);
		for(Order order : orderList) {
			order.setCustomer(customer);
			order.setPaymentMethod(paymentMethod);
			order.setStatus("결제완료");
			totalPrice= order.getMenu().getItemPrice()*order.getOrderQuantity();
			if(order.getPaymentMethod().equals("Free")) {
				if(customer.getMileage() < 10) {
					warningMsg = "마일리지 사용 불가능";
				}
			}
		}
		
		mav.addObject("warningMsg", warningMsg);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("customer", customer);
		mav.addObject("orderList", orderList);
		mav.setViewName("order_final");
		return mav;
	}
}
