package edu.sp5.javacafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


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

@Getter
@Setter
public class Order {
	private long oid;
	private long receiptNumber;
	private long orderNumber;
	private Menu menu;
	private long orderQuantity;
	private Customer customer;
	private Date orderDate;
	private String paymentMethod;
	private String status;
	
	public Order() {
		
	}
	
	public Order(Menu menu, long orderQuantity) {
		this.menu = menu;
		this.orderQuantity = orderQuantity;
	}
	
	/**
	 * 받은 주문을 객체로 생성할 때 메뉴정보와 주문수량 고객정보 결제방식을 받는다
	 */
	public Order(Menu menu, long orderQuantity, Customer customer, String paymentMethod) {
		super();
		this.menu = menu;
		this.orderQuantity = orderQuantity;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * DB에서 받아올경우 전체 정보를 저장하기 위함
	 */
	public Order(long oid, long receiptNumber, long orderNumber, Menu menu, long orderQuantity, Customer customer,
			Date orderDate, String paymentMethod, String status) {
		super();
		this.oid = oid;
		this.receiptNumber = receiptNumber;
		this.orderNumber = orderNumber;
		this.menu = menu;
		this.orderQuantity = orderQuantity;
		this.customer = customer;
		this.orderDate = orderDate;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}
}
