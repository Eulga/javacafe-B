package edu.sp5.javacafe.dao.derby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import edu.sp5.javacafe.domain.Customer;
import edu.sp5.javacafe.domain.Menu;
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

@SpringJUnitConfig(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class OrderDaoDerbyTest {
	
	@Autowired
	private OrderDaoDerby daoDerby;
	
	@Test
	@Transactional
	public void addOrder() {
		Menu menu = new Menu("아메리카노", 2500.0);
		Customer customer = new Customer("", 0);
		Order order = new Order();
		order.setReceiptNumber(1);
		order.setMenu(menu);
		order.setCustomer(customer);
		order.setOrderNumber(1);
		order.setOrderQuantity(2);
		order.setReceiptNumber(13213);
		order.setPaymentMethod("현금");
		order.setStatus("결제완료");
		
		daoDerby.addOrder(order);
	}
}
