package edu.sp5.javacafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.command.MainNaverCommand;
import edu.sp5.javacafe.domain.CafeMaster;
import edu.sp5.javacafe.service.CafeMasterService;


import org.springframework.beans.factory.annotation.Autowired;

@Controller("loginContorller")
public class LoginController {
	
	@Autowired
	CafeMasterService cmService;
	
	@GetMapping("index")
	public ModelAndView viewIndex() {
		ModelAndView mav = new ModelAndView();
		CafeMaster cafeMaster = cmService.findCafeMaster();
		mav.addObject("masterNumber", cafeMaster.getMasterNumber());
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute CafeMaster inputcafeMaster) {
		CafeMaster cafeMaster = cmService.findCafeMaster();
		if(cafeMaster.getMasterNumber() == inputcafeMaster.getMasterNumber() &&
				cafeMaster.getPasswd().equals(inputcafeMaster.getPasswd())) {
			return "/home";
		} else {
			return "redirect:/index";
		}
	}
}
