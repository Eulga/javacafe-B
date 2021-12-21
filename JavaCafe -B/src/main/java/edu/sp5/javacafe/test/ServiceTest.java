package edu.sp5.javacafe.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import edu.sp5.javacafe.config.JavaCafeConfig;
import edu.sp5.javacafe.domain.CafeMaster;
import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.service.CafeMasterService;
import edu.sp5.javacafe.service.CustomerService;
import edu.sp5.javacafe.service.MenuService;

public class ServiceTest {
	public static CafeMasterService cmService;
	public static CustomerService cusService;
	public static MenuService menuService;
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(JavaCafeConfig.class);
		menuService = context.getBean("menuService", MenuService.class);
		cusService = context.getBean("customerService", CustomerService.class);
		cmService = context.getBean("cafeMasterService", CafeMasterService.class);
		
		cafeMasterServiceTest();
		//customerServiceTest();
		//menuServiceTest();
		
		context.close();
	}
	
	public static void cafeMasterServiceTest() {
		CafeMaster cm = cmService.findCafeMaster();
		System.out.println(cm.getMasterNumber());
	}
	
	public static void customerServiceTest() {
		//cusservice.addCustomer(new Customer("010-1234-5678", 0));
		Customer cus = cusService.findCustomerByCustomerNumber("010-1234-5678");
		
		System.out.println(cus.toString());
	}
	
	public static void menuServiceTest() {
//		menuService.addMenu("아메리카노", "Drink", 2000.0, "path", "always");
//		Menu menu = menuService.findMenuByItemNumber(151555);
		Menu menu = menuService.findMenuByItemName("아메리카노");
		System.out.println(menu);
	}
}
