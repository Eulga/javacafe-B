package edu.sp5.javacafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("pageController")
public class PageController {
	
	@GetMapping("/home")
	public String gomain(HttpServletRequest req) {
		HttpSession session = req.getSession();
		//session.removeAttribute("orderList");
		//session.removeAttribute("menu");
		session.invalidate();
		return "/home";
	}
	
}
