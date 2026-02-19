package com.restaurantmanagement;

public class CloudKitchenOrder implements Order{
	
	
	String customerName;
	double orderAmount;
	int deliveryDistance;
	private static int orderIdRandom = 10101;
	

	public CloudKitchenOrder(String customerName, double orderAmount, int deliveryDistance) {
		super();
		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.deliveryDistance = deliveryDistance;
	}
	

	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public double getOrderAmount() {
		return orderAmount;
	}


	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getDeliveryDistance() {
		return deliveryDistance;
	}


	public void setDeliveryDistance(int deliveryDistance) {
		this.deliveryDistance = deliveryDistance;
	}


	@Override
	public double calculateFinalAmount() {
		if( deliveryDistance >=0 && deliveryDistance <=5) {
			return orderAmount + 30;
		}
		else {
			return orderAmount+60;
		}
		
	}

	@Override
	public String getOrderDetails() {
		int orderID=orderIdRandom++;
		System.out.println("Order Details for your Grocery Order -- " + (orderID) + " --> " +"amount " + calculateFinalAmount());
		return "CLOUD -- "+ customerName +" - "+orderID + " --> " + calculateFinalAmount() +" for your delivery distance " + deliveryDistance;
	}
	
	
	
/*
	 * Cloud Kitchen Order
=================
Inputs
    Customer Name
    Order Amount
    Delivery Distance (in km)

Pricing Rules
========
Delivery charge:
    Up to 5 km → ₹30
    Above 5 km → ₹60
    Final Amount = Order Amount + Delivery Charge    
*/

}
