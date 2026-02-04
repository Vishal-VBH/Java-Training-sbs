package com.banking;

public class BankingOperations {

	
	int account_number;
	String account_holder_name;
	String password;
	double balance;


	public boolean validatesPassword(String password) {
		if(!this.password.equals(password)) {
			return false;
		}
		return true;
		
	}
	
	
	public BankingOperations(int account_number, String account_holder_name, String password, double balance) {
		this.account_number = account_number;
		this.account_holder_name = account_holder_name;
		this.password = password;
		this.balance = balance;
	}
	
	public void SwitchOperations(int selection, BankingOperations bankop,double amountValue, String passwordvalue) {
		switch (selection) {
		case 1: {
			bankop.addBalance(amountValue, passwordvalue);
			break;
		}
		case 2: {
			bankop.withdrawAmount(amountValue, passwordvalue);
			break;
			
		}
		default:
			System.out.println("Please Enter the valid selection");
			break;
			
		}
	}

	public void addBalance(double amount , String password) {
		
		if(validatesPassword(password)) {
		System.out.println("Adding the balance " + amount);
		if(amount > 0) {
		balance =balance + amount;
		}else {
			System.out.println("Amount should More than 1 rupee....");
		}
		
		System.out.println("Successfully added the balance of " + amount);
		System.out.println("Current available Balance is : " + balance);
		}else {
			System.err.println("Invalid Password");
		}
	}
	
	public void withdrawAmount(double amount, String password) {
		if(validatesPassword(password)) {
		System.out.println(amount + " Withdrawal initiated.....");
		
		if(amount > balance) {
			System.out.println("Insufficient Balance.....please enter the amount within the balance");
		}else {
			System.out.println();
			balance = balance - amount;
			System.out.println("Successfully withdrawal of "+amount+" is Successfull....");
			System.out.println("Current available Balance is : " + balance);
		}
		}else {
			System.err.println("Invalid Password");
		}
	}
}
