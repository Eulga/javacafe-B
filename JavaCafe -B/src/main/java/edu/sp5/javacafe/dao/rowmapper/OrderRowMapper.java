package edu.sp5.javacafe.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Menu;
import edu.sp5.javacafe.domain.Order;

public class OrderRowMapper implements RowMapper<Order> {

	/**	
	 * oid				고유번호
	 * receiptNumber	영수증번호
	 * orderNumber		주문번호
	 * menu				상품명,가격					- itemName, itemPrice
	 * orderQuantity	주문량
	 * customer			구매자번호(0 일시 비회원주문)	- customerNumber
	 * orderDate		주문날짜
	 * paymentMethod	결제방식(현금, 카드?신용?)
	 * status			최종주문상태(결제완료, 환불, 주문취소? 등)
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
