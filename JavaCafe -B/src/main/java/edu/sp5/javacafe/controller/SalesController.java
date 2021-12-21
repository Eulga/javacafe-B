package edu.sp5.javacafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.domain.Order;
import edu.sp5.javacafe.service.OrderService;

@Controller("salesController")
public class SalesController {
	
	@Autowired
	OrderService orderService;
	
	//매출 정보
		@GetMapping("/salesManagement")
		public ModelAndView salesManagement() {
			ModelAndView mav = new ModelAndView();
			List<Order> orderList = orderService.findAllOrder();
			mav.addObject("orderList",orderList);
			mav.setViewName("sales_management");
			return mav;
		}
			//
		@GetMapping("/dailySalesIndex")
		public ModelAndView dailySalesIndex() {
			ModelAndView mav = new ModelAndView();
			List<Order> todaysOrder = orderService.findOrderByOrderDate();
			mav.addObject("dayList", todaysOrder);
			mav.setViewName("daily_orderlist");
			return mav;
		}
		
		@GetMapping("/weeklySalesIndex")
		public ModelAndView weeklySalesIndex() {
			ModelAndView mav = new ModelAndView();
			List<Order> weeklyOrder = orderService.findAllOrder();
			mav.addObject("weekList", weeklyOrder);
			mav.setViewName("weekly_orderlist");
			return mav;
		}
		
		@GetMapping("/monthlySalesIndex")
		public ModelAndView monthlySalesIndex() {
			ModelAndView mav = new ModelAndView();
			List<Order> monthlyOrder = orderService.findAllOrder();
			mav.addObject("monthList", monthlyOrder);
			mav.setViewName("/monthly_orderlist");
			return mav;
		}
}
