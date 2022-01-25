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
 * oid				������ȣ
 * receiptNumber	��������ȣ
 * orderNumber		�ֹ���ȣ
 * menu				��ǰ��, ����
 * orderQuantity	�ֹ���
 * customer			�����ڹ�ȣ(0 �Ͻ� ��ȸ���ֹ�)
 * orderDate		�ֹ���¥
 * paymentMethod	�������(����, ī��?�ſ�?)
 * status			�����ֹ�����(�����Ϸ�, ȯ�� ��)
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
		jdbcTemplate.update(sql, order.getReceiptNumber(), order.getOrderNumber(), order.getMenu().getItemName(), order.getMenu().getItemPrice(),
				order.getOrderQuantity(), order.getCustomer().getCustomerNumber(), order.getPaymentMethod(), order.getStatus());
	}
	
	@Override
	public void deleteOrderByReceiptNumber(long receiptNumber) {
		String sql = "DELETE FROM ORDERLIST WHERE receiptNumber = ?";
		jdbcTemplate.update(sql, receiptNumber);
	}

	@Override
	public List<Order> findOrderByReceiptNumber(long receiptNumber) {
		String sql = "SELECT * FROM ORDERLIST WHERE receiptNumber = ?";
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
