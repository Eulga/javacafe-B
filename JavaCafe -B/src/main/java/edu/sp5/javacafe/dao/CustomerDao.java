package edu.sp5.javacafe.dao;

import java.util.List;

import edu.sp5.javacafe.domain.Customer;


public interface CustomerDao {
	
	/**
	 * 고객추가
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 모든 고객 리스트 출력
	 * @return
	 */
	public List<Customer> findAllCustomers();
	
	/**
	 * 고객의 휴대전화번호를 이용하여
	 * 해당 고객의 정보 출력
	 * @return
	 */
	public Customer findCustomerByCustomerNumber(String phoneNumber);
	
	/**
	 * 휴대폰번호 변경
	 */
	public void updateCustomer(String customerNumber, String newCustomerNumber);
	
	/**
	 * 마일리지 적립
	 */
	public void accumMileage(long mileage, String customerNumber);
	
	/**
	 * 고객정보삭제
	 */
	public void deleteCustomer(Customer customer);

}
