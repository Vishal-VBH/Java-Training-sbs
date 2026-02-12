package com.training.threads;

public class BankDriver {

	public static void main(String[] args) {
		
		
		BankAccount account = new BankAccount(20000);
		
		Runnable atm = () -> account.withdraw(1000);
		Runnable upi = () -> account.withdraw(2200);
		
		Thread runAtm = new Thread(atm , "ATM-Thread ");
		Thread runUpi = new Thread(upi , "UPI-Thread ");
		
		runAtm.start();
		runUpi.start();
		
	}
}
