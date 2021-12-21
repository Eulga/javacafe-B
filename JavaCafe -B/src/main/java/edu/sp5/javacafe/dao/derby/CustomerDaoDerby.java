package edu.sp5.javacafe.dao.derby;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.javacafe.dao.CustomerDao;
import edu.sp5.javacafe.dao.rowmapper.CustomerRowMapper;
import edu.sp5.javacafe.domain.Customer;


public class CustomerDaoDerby implements CustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * �ű԰� �߰�
	 */
	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(customerNumber, mileage) VALUES (?, ?)";
		jdbcTemplate.update(sql, customer.getCustomerNumber(), customer.getMileage());
	}
	
	/**
	 * ��ü �� ��ȸ�ϱ�
	 */
	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	/**
	 * ȸ�� ��ȣ(�޴���ȭ ��ȣ)�� 
	 * Ư�� �� ��ȸ�ϱ�
	 */
	@Override
	public Customer findCustomerByCustomerNumber(String customerNumber) {
		String sql = "SELECT * FROM Customer WHERE customerNumber = ?";
		
		try {			
			return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), customerNumber);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/**
	 * ȸ������ ����
	 */
	@Override
	public void updateCustomer(String customerNumber, String newCustomerNumber) {
		String sql = "UPDATE Customer SET customerNumber = ? WHERE customerNumber = ?";
		jdbcTemplate.update(sql, newCustomerNumber, customerNumber);
	}
	
	/**
	 * ���ϸ��� ����
	 */
	@Override
	public void accumMileage(long mileage, String customerNumber) {
		String sql = "UPDATE Customer SET mileage = ? WHERE customerNumber = ?";
		jdbcTemplate.update(sql, mileage, customerNumber);
	}
	
	/**
	 * ȸ�� ����
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		String sql = "DELETE FROM Customer WHERE customerNumber = ?";		
		jdbcTemplate.update(sql, customer);
	}	
}
