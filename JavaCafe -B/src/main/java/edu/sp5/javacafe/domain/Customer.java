package edu.sp5.javacafe.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
	private long cid;
	private String customerNumber;
	private long mileage;
	
	public Customer () {
		
	}
	
	public Customer(String customerNumber, long mileage) {
		super();
		this.customerNumber = customerNumber;
		this.mileage = mileage;
	}
	
	public void addMileagePoint(int mileagePoint) {
		this.mileage += mileagePoint;
	}
	
	public void subMileagePoint(int mileagePoint) {
		this.mileage -= mileagePoint;
	}
	
}
