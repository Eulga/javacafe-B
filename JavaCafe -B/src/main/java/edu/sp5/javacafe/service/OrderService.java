package edu.sp5.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.sp5.javacafe.dao.derby.OrderDaoDerby;
import edu.sp5.javacafe.domain.Order;

public class OrderService {
	
	@Autowired
	private OrderDaoDerby orderDao;

	@Transactional
	public Order addOrder(Order order) {
		orderDao.addOrder(order);
		return order;
	}

	public void deleteOrderByReceiptNumber(long orderNumber) {
		orderDao.deleteOrderByReceiptNumber(orderNumber);
	}
	
	public void findOrderByReceiptNumber(long orderNumber) {
		orderDao.findOrderByReceiptNumber(orderNumber);
	}
	
	public List<Order> findAllOrder() {
		return orderDao.findAllOrder();
	}
	
	public List<Order> findOrderByOrderDate() {
		return orderDao.findOrderByOrderDate();
	}
	
}
