package edu.sp5.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.domain.Order;
import edu.sp5.javacafe.service.MenuService;

@Controller("orderController")
public class OrderController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("/doOrder")
	public ModelAndView doOrder() {
		ModelAndView mav = new ModelAndView();
		List<Menu> menuList = menuService.findAllMenus();
		mav.addObject("menuList", menuList);
		mav.setViewName("order_addmenu");
		return mav;
	}
	
	@PostMapping("/changeQuantity")
	public String chanageQuantity(HttpServletRequest req, @RequestParam("itemNumber") long itemNumber, @RequestParam("orderQuantity") long orderQuantity) {
		HttpSession session = req.getSession();
		List<Order> orderList = (List<Order>) session.getAttribute("orderList");
		
		for(Order order : orderList) {
			if(order.getMenu().getItemNumber() == itemNumber)
			order.setOrderQuantity(orderQuantity);
		}
		
		return "redirect:/addOrder";
	}
	
	@GetMapping("/addOrder")
	public ModelAndView addOrder(@SessionAttribute("orderList") List<Order> orderList) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("orderList", orderList);
		mav.setViewName("order_list");
		
		return mav;
	}
	
	@PostMapping("/addOrder")
	public ModelAndView addOrder(@SessionAttribute("orderList") List<Order> orderList, @ModelAttribute Menu menu, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(orderList == null) {
			orderList = new ArrayList<Order>();
			orderList.add(new Order(menu, 1));
			session.setAttribute("orderList", orderList);
		}else {
			boolean isNotEqual = true;
			for(Order order : orderList) {
				if(order.getMenu().getItemNumber() == menu.getItemNumber()) {
					order.setOrderQuantity(order.getOrderQuantity()+1);
					isNotEqual = false;
					break;
				}
			}
			if(isNotEqual)	orderList.add(new Order(menu, 1));
		}
		
		mav.addObject("orderList", orderList);
		mav.setViewName("order_list");
		
		return mav;
	}
	
	@GetMapping("/deleteOrder")
	public String deleteOrder(@SessionAttribute("orderList") List<Order> orderList, @RequestParam("itemNumber") long itemNumber) {
		int getIndex = 0;
		
		for(Order order : orderList) {
			if(order.getMenu().getItemNumber() == itemNumber) {
				break;
			}
			getIndex++;
		}
		orderList.remove(getIndex);
		
		return "redirect:/addOrder";
	}
	
}
