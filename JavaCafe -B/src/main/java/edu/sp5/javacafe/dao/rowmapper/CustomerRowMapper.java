package edu.sp5.javacafe.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.javacafe.domain.Customer;


public class CustomerRowMapper implements RowMapper<Customer>{
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer(rs.getString("customerNumber"),
				rs.getInt("mileage"));
		customer.setCid(rs.getLong("cid"));
		return customer;
	}
}
