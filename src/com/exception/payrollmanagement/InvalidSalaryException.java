package com.exception.payrollmanagement;

public class InvalidSalaryException extends Exception {

	@Override
	public String getMessage() {
		System.err.println("Invalid Base Salary/HRA- please enter value greater than 0 ");
		return "Invalid Base Salary";
		
	}
	public String getMessage(boolean contractEmp) {
		System.err.println("Invalid  Hours/Hourly rate- please enter value greater than 0 ");
		return "Invalid salary";
		
	}

}
