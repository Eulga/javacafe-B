package edu.sp5.javacafe.dao;

import java.util.List;

import edu.sp5.javacafe.domain.Order;

public interface OrderDao {
	public void addOrder(Order order);
	public List<Order> findOrderByReceiptNumber(long receiptNumber);
	public void deleteOrderByReceiptNumber(long receiptNumber);
}
