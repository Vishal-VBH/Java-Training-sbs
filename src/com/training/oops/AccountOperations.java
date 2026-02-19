package com.training.oops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountOperations {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		Customer nikhilCustomer = new Customer(101, "Nikhil", "abc@gmail.com");
		Account account = new SavingAccount(19891, 2000, nikhilCustomer);
		
		while (true) {
			
			try {
				System.out.println();
				System.out.println("For Withdrawal Press 1 and for Deposit Press 2");
				System.out.println("1. Withdrawal    2.Deposit Amount");
				System.out.println();
				int userInput = sc.nextInt();
				
				int withdrawOrDepositAmount = 0;
				
				if (userInput == 1) {
					System.out.println("Enter the amount you wish to withdraw...");
					withdrawOrDepositAmount = sc.nextInt();
					account.withdrawAmount(withdrawOrDepositAmount);
				} else if (userInput == 2) {
					System.out.println("Enter the amount you wish to Deposit...");
					withdrawOrDepositAmount = sc.nextInt();
					account.depositAmount(withdrawOrDepositAmount);
				} else {
					System.out.println("Please enter the valid input");
				}
			} catch (InputMismatchException e) {
				System.err.println("Please provide correct input...");
				sc.next();
			}
		}
	}
}