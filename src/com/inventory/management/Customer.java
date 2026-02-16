package com.inventory.management;

public class Customer {

	private int customerId;
	private String customerName;
	private Inventory inventory;
	
	private int purchaseQuantity;
	
	public Customer(int customerId, String customerName, Inventory inventory, int purchaseQuantity) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.inventory = inventory;
		this.purchaseQuantity = purchaseQuantity;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	

	
	
	
	
	
}
