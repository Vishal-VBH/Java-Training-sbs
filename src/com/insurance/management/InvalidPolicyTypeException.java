package com.insurance.management;

public class InvalidPolicyTypeException extends Exception {
	
	@Override
	public String getMessage() {
		System.out.println("Select only the policy which are listed !!");
		return "Invalid Policy";
	}

}
