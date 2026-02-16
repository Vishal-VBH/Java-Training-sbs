package com.inventory.management;

public class QuantityCannotBeZeroException extends RuntimeException {

	public QuantityCannotBeZeroException(String string) {
		super(string);
	}

}
