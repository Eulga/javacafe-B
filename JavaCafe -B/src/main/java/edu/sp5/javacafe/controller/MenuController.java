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
import org.springframework.web.servlet.ModelAndView;

import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.service.MenuService;

@Controller("menuController")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menuList")
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		List<Menu> menuList = menuService.findAllMenus();
		mav.addObject("menuList", menuList);
		mav.setViewName("/menus/delete_menu");
		return mav;
	}
	
	@GetMapping("/menuManagement")
	public ModelAndView menuManagement() {
		ModelAndView mav = new ModelAndView();
		List<Menu> menuList = new ArrayList<Menu>();
		menuList = menuService.findAllMenus();
		mav.addObject("menuList", menuList);
		mav.setViewName("/menu_management");
		return mav;
	}
	//�޴��߰�ȭ���̵�
	@GetMapping("/addMenu")
	public String addMenu() {
		return "/addmenu";
	}
	
	//�̹��� �Է�
	@PostMapping("/choiceImage")
	public String choiceItemImage(HttpServletRequest req, @ModelAttribute Menu menu) {
		HttpSession session = req.getSession();
		session.setAttribute("menu", menu);
		return "/select_menuImage";
	}
	
	//���� �޴��߰�
	@PostMapping("/addMenu")
	public String addMenu(@RequestParam("itemImage") String itemImage, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Menu menu = (Menu) session.getAttribute("menu");
		menu.setItemImage(itemImage);
		menuService.addMenu(menu);
		session.removeAttribute("menu");
		return "redirect:/menuManagement";
	}
	
	//�޴����� ����
	@GetMapping("/changeMenuInfo")
	public ModelAndView changeMenuInfo(HttpServletRequest req, @RequestParam("itemNumber") long itemNumber) {
		Menu menu = menuService.findMenuByItemNumber(itemNumber);
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", menu);
		mav.setViewName("/change_menu_info");
		return mav;
	}
	//�̹��� ����
	@PostMapping("/changeMenuImage")
	public String changeMenuImage(HttpServletRequest req, @ModelAttribute Menu menu) {
		HttpSession session = req.getSession();
		session.setAttribute("menu", menu);
		return "/change_menu_image";
	}
	
	//���� ����Ȯ��
	@PostMapping("/changeMenuInfo")
	public String changeMenuInfo(@RequestParam("itemImage") String itemImage, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Menu menu = (Menu)session.getAttribute("menu");
		menu.setItemImage(itemImage);
		menuService.updateMenu(menu);
		session.removeAttribute("menu");
		return "redirect:/menuManagement";
	}
	
	@GetMapping("/deleteMenu")
	public String changeMenu(@RequestParam("itemNumber") long itemNumber) {
		menuService.deleteMenu(itemNumber);
		return "redirect:/menuManagement";
	}
	
	/**
	 * stock ����
	 */
	
	@GetMapping("/stockManagement")
	public ModelAndView stockManagement() {
		ModelAndView mav = new ModelAndView();
		List<Menu> stockMenus = menuService.findAllMenusAndStock();
		mav.addObject("stockMenus", stockMenus);
		mav.setViewName("/stock_management");
		return mav;
	}
	
	@GetMapping("/changeStock")
	public ModelAndView changeStock(@RequestParam("itemNumber") long itemNumber) {
		ModelAndView mav = new ModelAndView();
		Menu stockMenu = menuService.findMenusAndStockByItemNumber(itemNumber);
		mav.addObject("menu", stockMenu);
		mav.setViewName("change_stock_quantity");
		return mav;
	}
	
	@PostMapping("/changeStock")
	public String changeStockQuantity(@RequestParam("itemNumber") long itemNumber, @RequestParam("newStockQuantity") long newStockQuantity) {
		menuService.setStock(itemNumber, newStockQuantity);
		return "redirect:/stockManagement";
	}
}
