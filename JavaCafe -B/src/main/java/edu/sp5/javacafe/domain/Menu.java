package edu.sp5.javacafe.domain;

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
	
	//주문용
	public Menu(String itemName, double itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	
	//메뉴등록용
	public Menu(long itemNumber, String itemName, String itemCategory, double itemPrice, String itemImage, String salesSeason) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.salesSeason = salesSeason;
	}

	//모든정보
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

	public long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(long itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getSalesSeason() {
		return salesSeason;
	}
	public void setSalesSeason(String salesSeason) {
		this.salesSeason = salesSeason;
	}
	public long getItemStock() {
		return itemStock;
	}
	public void setItemStock(long itemStock) {
		this.itemStock = itemStock;
	}

	@Override
	public String toString() {
		return "Menu [itemNumber=" + itemNumber + ", itemName=" + itemName + ", itemCategory=" + itemCategory
				+ ", itemPrice=" + itemPrice + ", itemImage=" + itemImage + ", salesSeason=" + salesSeason
				+ ", itemStock=" + itemStock + "]";
	}
	
	
}
