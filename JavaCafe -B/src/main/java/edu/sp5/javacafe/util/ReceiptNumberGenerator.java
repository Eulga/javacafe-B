package edu.sp5.javacafe.util;

import java.util.Random;

public class ReceiptNumberGenerator {
	
	public static long getReceiptNumber() {
		Random rand = new Random();
		long num = 0;
		for (int i = 0; i < 2; i++) {			
			num = rand.nextInt(100000000);
			while(num < 10000000) {
				num = rand.nextInt(100000000);
			}
		}
		return num;
	}
}
