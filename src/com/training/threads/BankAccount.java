package com.training.threads;

public class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}
	
	public synchronized void withdraw(double amount) {
		for(int i=1 ; i<=3 ; i++) {
			if(amount > 0 && amount  < balance) {
				System.out.println("Withdrawing.....from "+Thread.currentThread().getName());
				balance-=amount;
				System.out.println(Thread.currentThread().getName()+"Withdrawal successfull..");
				System.out.println("\n"+Thread.currentThread().getName()+"Remaining Balance : " + balance);
				
			}
		}
	}
}
