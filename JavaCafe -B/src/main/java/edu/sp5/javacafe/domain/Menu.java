package edu.sp5.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
	private long itemNumber;
	private String itemName;
	private String itemCategory;
	private double itemPrice;
	private String itemImage;
	private String salesSeason;
	private long itemStock;
	
	public Menu() {
		
	}
	
	//�ֹ���
	public Menu(String itemName, double itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	
	//�޴���Ͽ�
	public Menu(long itemNumber, String itemName, String itemCategory, double itemPrice, String itemImage, String salesSeason) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.salesSeason = salesSeason;
	}

	//�������
	public Menu(long itemNumber, String itemName, String itemCategory, double itemPrice, String itemImage,
			String salesSeason, long itemStock) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.salesSeason = salesSeason;
		this.itemStock = itemStock;
	}

	@Override
	public String toString() {
		return "Menu [itemNumber=" + itemNumber + ", itemName=" + itemName + ", itemCategory=" + itemCategory
				+ ", itemPrice=" + itemPrice + ", itemImage=" + itemImage + ", salesSeason=" + salesSeason
				+ ", itemStock=" + itemStock + "]";
	}
	
	
}
