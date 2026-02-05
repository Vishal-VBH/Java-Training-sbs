package com.restaurantmanagement;

public class GroceryOrder implements Order {

	
	String customerName;
	double orderAmount;
	boolean isMembershipHolder;
	
	private static int orderIdRandom = 10101;

	

	public GroceryOrder(String customerName, double orderAmount, boolean isMembershipHolder) {
		super();
		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.isMembershipHolder = isMembershipHolder;
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


	public boolean isMembershipHolder() {
		return isMembershipHolder;
	}


	public void setMembershipHolder(boolean isMembershipHolder) {
		this.isMembershipHolder = isMembershipHolder;
	}


	@Override
	public double calculateFinalAmount() {
		if(isMembershipHolder) {
			return (orderAmount - (orderAmount * 0.01));
		}else {
			return orderAmount;
		}

	}

	@Override
	public String getOrderDetails() {
		int orderID=orderIdRandom++;
		System.out.println("Order Details for your Grocery Order -- " + (orderID) + " --> " +"amount " + calculateFinalAmount());
		return "CLOUD -- "+ customerName +" - "+orderID + " --> " + calculateFinalAmount();
	}
	
	
	 /* Grocery Order
======
Inputs
   Customer Name
   Order Amount
   Is Membership Holder (true / false)

Pricing Rules
   If customer is a member:
   Apply 10% discount
   Otherwise:
       No discount
       Final Amount = Order Amount – Discount

	 */

}
