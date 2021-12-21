package edu.sp5.javacafe.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sp5.javacafe.dao.derby.CustomerDaoDerby;
import edu.sp5.javacafe.domain.Customer;

public class CustomerService {
	
	@Autowired
	private CustomerDaoDerby customerDao;
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer findCustomerByCustomerNumber(String customerNumber) {
		return customerDao.findCustomerByCustomerNumber(customerNumber);
	}
	
	public void updateMileage(Customer customer, long totalOrderQuantity) {
		customerDao.accumMileage(totalOrderQuantity, customer.getCustomerNumber());
	}
}
