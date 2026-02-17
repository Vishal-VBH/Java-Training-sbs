package com.inventory.management;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PurchaseStockDriver {

	public static void main(String[] args) {
		Inventory inventory = new Inventory(123, "Mobile", 10, true);

		Customer adam = new Customer(101, "Adam Smith", inventory, 2);

		Customer john = new Customer(102, "John Dev", inventory, 4);

		Customer simba = new Customer(103, "Simbha", inventory, 2);
		
		Customer[]  customers = {adam , john , simba};

		/*
		 * Thread purchase1 = new Thread( ()->{ int customerId = adam.getCustomerId();
		 * int purchaseQuantity = adam.getPurchaseQuantity();
		 * inventory.customerPurchase(customerId , purchaseQuantity); } ,
		 * "Adam's Thread");
		 * 
		 * 
		 * Thread purchase2 = new Thread( ()->{ int customerId = john.getCustomerId();
		 * int purchaseQuantity = john.getPurchaseQuantity();
		 * inventory.customerPurchase(customerId , purchaseQuantity); } ,
		 * "John's Thread");
		 * 
		 * Thread purchase3 = new Thread( ()->{ int customerId = simba.getCustomerId();
		 * int purchaseQuantity = simba.getPurchaseQuantity();
		 * inventory.customerPurchase(customerId , purchaseQuantity); } ,
		 * "Simba's Thread");
		 * 
		 * Thread purchase4 = new Thread( ()->{ int customerId = simba.getCustomerId();
		 * int purchaseQuantity = simba.getPurchaseQuantity();
		 * inventory.customerPurchase(customerId , purchaseQuantity); } ,
		 * "Simba's Thread");
		 * 
		 * 
			purchase1.start();
			purchase2.start();
			purchase3.start();
			purchase4.start();

		 */
		ExecutorService executor = Executors.newFixedThreadPool(4);

//		for(int i=1; i<=5 ; i++) {
//			executor.submit(()->{
//				int customerId = simba.getCustomerId();
//				int purchaseQuantity = simba.getPurchaseQuantity();
//				inventory.customerPurchase(customerId , purchaseQuantity);
//			} , "Simba's Thread");
//		}
//
//		executor.submit(() -> inventory.customerPurchase(adam.getCustomerId(), adam.getPurchaseQuantity()));
//
//		executor.submit(() -> inventory.customerPurchase(john.getCustomerId(), john.getPurchaseQuantity()));
//
//		executor.submit(() -> inventory.customerPurchase(simba.getCustomerId(), simba.getPurchaseQuantity()));
//
//		executor.shutdown();

//		executor.submit(() -> {
//			Thread.currentThread().setName("Adam's Thread");
//			int customerId = adam.getCustomerId();
//			int purchaseQuantity = adam.getPurchaseQuantity();
//			inventory.customerPurchase(customerId, purchaseQuantity);
//		});
//
//		executor.submit(() -> {
//			Thread.currentThread().setName("John's Thread");
//			inventory.customerPurchase(john.getCustomerId(), john.getPurchaseQuantity());
//		});
//
//		executor.submit(() -> {
//			Thread.currentThread().setName("Simba's Thread");
//			inventory.customerPurchase(simba.getCustomerId(), simba.getPurchaseQuantity());
//		});
		
//		or
		for (Customer customer : customers) {

		    executor.submit(() -> {

		        Thread.currentThread().setName(customer.getCustomerName() + "-Thread");

		        inventory.customerPurchase(
		                customer.getCustomerId(),
		                customer.getPurchaseQuantity()
		        );

		    });
		}

		
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();

	}
}
