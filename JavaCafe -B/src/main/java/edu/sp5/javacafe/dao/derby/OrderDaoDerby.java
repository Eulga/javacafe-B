package edu.sp5.javacafe.dao.derby;

import static java.sql.Types.BIGINT;
import static java.sql.Types.DOUBLE;
import static java.sql.Types.VARCHAR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.javacafe.dao.OrderDao;
import edu.sp5.javacafe.dao.rowmapper.OrderRowMapper;
import edu.sp5.javacafe.domain.Order;

/**	
 * oid				고유번호
 * receiptNumber	영수증번호
 * orderNumber		주문번호
 * menu				상품명, 가격
 * orderQuantity	주문량
 * customer			구매자번호(0 일시 비회원주문)
 * orderDate		주문날짜
 * paymentMethod	결제방식(현금, 카드?신용?)
 * status			최종주문상태(결제완료, 환불 등)
 * @author kimjaeik
 *
 */

public class OrderDaoDerby implements OrderDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO ORDERLIST("
				+ "receiptNumber, orderNumber, itemName, itemprice, orderQuantity, customerNumber, paymentMethod, status)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = new Object[] {order.getReceiptNumber(), order.getOrderNumber(), order.getMenu().getItemName(), order.getMenu().getItemPrice(),
				order.getOrderQuantity(), order.getCustomer().getCustomerNumber(), order.getPaymentMethod(), order.getStatus()};
		int[] types = new int[] {BIGINT, BIGINT, VARCHAR, DOUBLE, BIGINT, VARCHAR, VARCHAR, VARCHAR};
		jdbcTemplate.update(sql, args, types);
	}
	
	@Override
	public void deleteOrderByReceiptNumber(long receiptNumber) {
		String sql = "DELETE FROM ORDERLIST WHERE receiptNumber = ?";
		jdbcTemplate.update(sql, receiptNumber);
	}

	@Override
	public List<Order> findOrderByReceiptNumber(long receiptNumber) {
		String sql = "SELECET * FROM ORDERLIST WHERE receiptNumber = ?";
		return jdbcTemplate.query(sql, new OrderRowMapper(), receiptNumber);
	}
	
	public List<Order> findOrderByOrderDate(){
		String sql = "SELECT * FROM ORDERLIST WHERE DATE(orderDate) = CURRENT_DATE";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}
	
	public List<Order> DailyOrderList(){
		String sql = "SELECT receiptNumber, orderNumber, itemName, orderQuantity, customerNumber, orderDate, paymentMethod, (itemprice * orderQuantity) AS orderPrice"
				+ "	FROM OrderList"
				+ "WHERE DATE(orderDate) = CURRENT_DATE";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}
	public List<Order> WeeklyOrderList(){
		String sql = "SELECT * FROM OrderList";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}
	public Order MonthlyOrderList() {
		String sql = "SELECT MONTH(orderDate), SUM(itemPrice * orderQuantity) FROM OrderList WHERE MONTH(orderDate) BETWEEN ? AND ?";
		return (Order) jdbcTemplate.query(sql, new OrderRowMapper());
	}
	
	public List<Order> findAllOrder() {
		String sql = "SELECT * FROM OrderList";
		return jdbcTemplate.query(sql, new OrderRowMapper());
		
	}

}
