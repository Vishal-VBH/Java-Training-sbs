package com.lambda.payment;

public class InvalidAmountException extends RuntimeException {

	public InvalidAmountException(String string) {
        super("Amount must be greater than 0");
    }
	
	public InvalidAmountException() {
        super("Amount must be greater than 0");
    }
}
