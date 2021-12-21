package edu.sp5.javacafe.dao.derby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Menu;
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

@SpringJUnitConfig(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class OrderDaoDerbyTest {
	
	@Autowired
	private OrderDaoDerby daoDerby;
	
	@Test
	@Transactional
	public void addOrder() {
		Menu menu = new Menu("�Ƹ޸�ī��", 2500.0);
		Customer customer = new Customer("", 0);
		Order order = new Order();
		order.setReceiptNumber(1);
		order.setMenu(menu);
		order.setCustomer(customer);
		order.setOrderNumber(1);
		order.setOrderQuantity(2);
		order.setReceiptNumber(13213);
		order.setPaymentMethod("����");
		order.setStatus("�����Ϸ�");
		
		daoDerby.addOrder(order);
	}
}
