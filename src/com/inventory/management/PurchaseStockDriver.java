package com.inventory.management;

public class PurchaseStockDriver {

	public static void main(String[] args) {
		Inventory inventory = new Inventory(123, "Mobile", 10, true);
		
		Customer adam = new Customer(101, "Adam Smith", inventory, 2);
		
		Customer john = new Customer(102, "John Dev", inventory, 4);
		
		Customer simba = new Customer(103, "Simbha", inventory, 3);

		Thread purchase1 = new Thread( ()->{
			int customerId = adam.getCustomerId();
			int purchaseQuantity = adam.getPurchaseQuantity();
			inventory.customerPurchase(customerId , purchaseQuantity);
		} , "Adam's Thread");
		
		
		Thread purchase2 = new Thread( ()->{
			int customerId = john.getCustomerId();
			int purchaseQuantity = john.getPurchaseQuantity();
			inventory.customerPurchase(customerId , purchaseQuantity);
		} , "John's Thread");
		
		Thread purchase3 = new Thread( ()->{
			int customerId = simba.getCustomerId();
			int purchaseQuantity = simba.getPurchaseQuantity();
			inventory.customerPurchase(customerId , purchaseQuantity);
		} , "John's Thread");
		
		Thread purchase4 = new Thread( ()->{
			int customerId = simba.getCustomerId();
			int purchaseQuantity = simba.getPurchaseQuantity();
			inventory.customerPurchase(customerId , purchaseQuantity);
		} , "John's Thread");
		
		
		purchase1.start();
		purchase2.start();
		purchase3.start();
		purchase4.start();
				
	}
}
