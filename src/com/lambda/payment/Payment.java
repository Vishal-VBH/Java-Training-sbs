package com.lambda.payment;

import java.util.Random;
import java.util.function.Supplier;

public class Payment {

	private Integer paymentId;
	private Double amount;
	private boolean paymentStatus;
	private String paymentReference;
	
	
	public String getPaymentReference() {
		return paymentReference;
	}



	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}



	public Payment(Integer paymentId, Double amount, boolean paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}
	


	public Integer getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public boolean isPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	 @Override
	    public String toString() {
	        return "Payment Receipt\n" +
	               "----------------\n" +
	               "Payment ID     : " + paymentId + "\n" +
	               "Amount         : " + amount + "\n" +
	               "Status         : " + (paymentStatus ? "SUCCESS" : "FAILED");
	    }


	
	
	
	
}
