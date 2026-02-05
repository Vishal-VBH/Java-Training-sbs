package com.training.oops;

public class SavingAccount extends Account{
	public SavingAccount(long accountNumber, double balance, Customer customer) {
		super(accountNumber, balance, customer);
	}

	final int minimumBalance = 1000;

	@Override
	public void withdrawAmount(double amount) {
		
		if((balance-amount) < 1000) {
			System.err.println("Minumum Balance is not Maintained....");
			System.err.println("Returning back to homepage");
		}
		else if(amount < balance) {
			System.out.println("Withdrawal process initiated.....");
			balance = balance -amount;
			System.out.println("Withdrawal Successfull....Available Balance : "+balance);
		}else {
			System.err.println("Insufficient Balance...");
		}
		
	}

	@Override
	public void depositAmount(double amount) {
		System.out.println("The deposit process is initiated....");
		
		if(amount < 0) {
			System.err.println("Please enter the amount more than 0 rupees...");
		}
		balance += amount;
		System.out.println("Balance updated Successfully - Available Balance : " + balance);
	}

}
