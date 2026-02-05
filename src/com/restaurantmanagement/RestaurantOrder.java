package com.restaurantmanagement;

public class RestaurantOrder implements Order{

	
	String customerName;
	double orderAmount;
	double gstPercentage = 0.05; //5% percentage
	private static int orderIdRandom = 10101;

	
	public RestaurantOrder(String customerName, double orderAmount) {
		super();
		this.customerName = customerName;
		this.orderAmount = orderAmount;
	
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


	@Override
	public double calculateFinalAmount() {
		
		return orderAmount + (gstPercentage * orderAmount);
	}

	@Override
	public String getOrderDetails() {
		int orderID=orderIdRandom++;
		System.out.println("Order Details for your Grocery Order -- " + (orderID) + " --> " +"amount " + calculateFinalAmount());
		return "CLOUD -- "+ customerName +" - "+orderID + " --> " + calculateFinalAmount();
	}
	
	
	/*
	 * Restaurant Order
	===============
	Inputs
	    Customer Name
	    Order Amount
	    GST Percentage
	    
	Pricing Rules
	    GST is applied on the order amount
	    Final Amount = Order Amount + GST
	    
	 */

}
