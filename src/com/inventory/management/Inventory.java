package com.inventory.management;

public class Inventory {

	private int productId;
	private String productName;
	private int productStock = 10;
	private boolean isAvailable;

	public Inventory(int productId, String productName, int productStock, boolean isAvailable) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productStock = productStock;
		this.isAvailable = isAvailable;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productStock=" + productStock
				+ ", isAvailable=" + isAvailable + "]";
	}

	public synchronized boolean customerPurchase(int customerId, int quantity) {
		try {
		if (quantity <= 0) {
			throw new QuantityCannotBeZeroException("Quantity must be greater than 0");
		}
		if (productStock == 0) {
			throw new StockNotPresentException("Stock unavailable");
		}
		if (quantity <= productStock) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			productStock -= quantity;
			if (productStock == 0) {
				isAvailable = false;
			}
			System.out.println("Customer: "+Thread.currentThread().getName() +" - Customer  id " + customerId + " purchased " + quantity + " units. Remaining stock: " + productStock);

			return true;
		} else {
			System.out.println("Customer " + customerId + " failed to purchase " + quantity
					+ " units. Stock available: " + productStock);

			return false;
		}
	}catch( QuantityCannotBeZeroException | StockNotPresentException e) {
		System.err.println(" Error : "+Thread.currentThread().getName()+" - " + e.getMessage());
		return false;
	}
}
}
