package edu.sp5.javacafe.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.domain.Order;

public class OrderRowMapper implements RowMapper<Order> {

	/**	
	 * oid				������ȣ
	 * receiptNumber	��������ȣ
	 * orderNumber		�ֹ���ȣ
	 * menu				��ǰ��,����					- itemName, itemPrice
	 * orderQuantity	�ֹ���
	 * customer			�����ڹ�ȣ(0 �Ͻ� ��ȸ���ֹ�)	- customerNumber
	 * orderDate		�ֹ���¥
	 * paymentMethod	�������(����, ī��?�ſ�?)
	 * status			�����ֹ�����(�����Ϸ�, ȯ��, �ֹ����? ��)
	 * @author kimjaeik
	 * 
	 * Order(long oid, long receiptNumber, long orderNumber, Menu menu, long orderQuantity, Customer customer,
			Date orderDate, String paymentMethod, String status)
	 */

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerNumber(rs.getString("customerNumber"));
		Menu menu = new Menu(rs.getString("itemName"), rs.getDouble("itemPrice"));
		Order order = new Order(rs.getLong("oid"), rs.getLong("receiptNumber"), rs.getLong("orderNumber"),
				menu, rs.getLong("orderQuantity"), customer, rs.getTimestamp("orderDate"), rs.getString("paymentMethod"), rs.getString("status"));
		
		return order;
	}

}
