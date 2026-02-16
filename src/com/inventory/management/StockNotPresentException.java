package com.inventory.management;

public class StockNotPresentException extends RuntimeException {

	public StockNotPresentException(String message) {
		super(message);
	}

	
}
