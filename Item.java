package com.basket.manager;

public class Item {
	

	private String itemName;
	private int quantity;
	private double price;
	
	public Item(){}
	public Item(String itemName, int quantity, double price) {
		super();

		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "\n----Item Detail----" + 
				"\nItemName= " + itemName +
				"\nQuantity= " + quantity +
				"\nUnitPrice= " + price;
	}

}
