package edu.sp5.javacafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


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
	 * ���� �ֹ��� ��ü�� ������ �� �޴������� �ֹ����� ������ ��������� �޴´�
	 */
	public Order(Menu menu, long orderQuantity, Customer customer, String paymentMethod) {
		super();
		this.menu = menu;
		this.orderQuantity = orderQuantity;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * DB���� �޾ƿð�� ��ü ������ �����ϱ� ����
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
