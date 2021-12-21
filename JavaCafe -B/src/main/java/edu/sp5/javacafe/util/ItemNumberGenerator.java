package edu.sp5.javacafe.util;

import java.util.Random;

public class ItemNumberGenerator {
	public static long getItemNumber() {
		Random rand = new Random();
		long num = 0;
		for (int i = 0; i < 2; i++) {			
			num = rand.nextInt(1000000);
			while(num < 100000) {
				num = rand.nextInt(1000000);
			}
		}
		return num;
	}
}
