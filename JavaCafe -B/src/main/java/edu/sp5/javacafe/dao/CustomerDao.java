package edu.sp5.javacafe.dao;

import java.util.List;

import edu.sp5.javacafe.domain.Customer;


public interface CustomerDao {
	
	/**
	 * ���߰�
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * ��� �� ����Ʈ ���
	 * @return
	 */
	public List<Customer> findAllCustomers();
	
	/**
	 * ���� �޴���ȭ��ȣ�� �̿��Ͽ�
	 * �ش� ���� ���� ���
	 * @return
	 */
	public Customer findCustomerByCustomerNumber(String phoneNumber);
	
	/**
	 * �޴�����ȣ ����
	 */
	public void updateCustomer(String customerNumber, String newCustomerNumber);
	
	/**
	 * ���ϸ��� ����
	 */
	public void accumMileage(long mileage, String customerNumber);
	
	/**
	 * ����������
	 */
	public void deleteCustomer(Customer customer);

}
