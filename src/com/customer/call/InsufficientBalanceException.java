package com.customer.call;

public class InsufficientBalanceException extends RuntimeException {

	public InsufficientBalanceException(String message){
		super("Insufficient Balance");
	}
}
