package edu.sp5.javacafe.util;

public class OrderNumber {
	private static long orderNumber = 1;
	
	public static long getOrderNumber() {
		return orderNumber++;
	}
}
