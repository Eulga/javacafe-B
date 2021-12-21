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
	 * 신규고객 추가
	 */
	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(customerNumber, mileage) VALUES (?, ?)";
		jdbcTemplate.update(sql, customer.getCustomerNumber(), customer.getMileage());
	}
	
	/**
	 * 전체 고객 조회하기
	 */
	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	/**
	 * 회원 번호(휴대전화 번호)로 
	 * 특정 고객 조회하기
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
	 * 회원정보 수정
	 */
	@Override
	public void updateCustomer(String customerNumber, String newCustomerNumber) {
		String sql = "UPDATE Customer SET customerNumber = ? WHERE customerNumber = ?";
		jdbcTemplate.update(sql, newCustomerNumber, customerNumber);
	}
	
	/**
	 * 마일리지 적립
	 */
	@Override
	public void accumMileage(long mileage, String customerNumber) {
		String sql = "UPDATE Customer SET mileage = ? WHERE customerNumber = ?";
		jdbcTemplate.update(sql, mileage, customerNumber);
	}
	
	/**
	 * 회원 삭제
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		String sql = "DELETE FROM Customer WHERE customerNumber = ?";		
		jdbcTemplate.update(sql, customer);
	}	
}
