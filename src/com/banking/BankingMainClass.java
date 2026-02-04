package com.banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingMainClass {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		BankingOperations vishalAccount = null;
	
		try {
			System.out.println("Enter the Account number");
			int accountNumber= sc.nextInt();
			System.out.println("Enter the Name of the Account Holder..");
			String holderName = sc.next();
			
			System.out.println("Set the Password for your account and remember it..");
			String password = sc.next();
			
			System.out.println("Enter the minimum Balance....");
			double minimumAmount = sc.nextDouble();
			
			
			vishalAccount = new BankingOperations(accountNumber, holderName, password, minimumAmount);
			
		} catch(InputMismatchException e) {
			System.err.println("Enter Only Number values...");		
		
			}
		
		System.out.println("Choose any one of the operations....");
		System.out.println("1.Add Balance ");
		System.out.println("2.Withdraw Balance ");
		int selection = 0;
		double amountValue=0;
		String passwordvalue = null;
		try {
			selection=sc.nextInt();
			System.out.println("Enter the amount...");
			amountValue = sc.nextDouble();
			System.out.println("Please enter the Password");
			passwordvalue=sc.next();
			
			
		}catch( InputMismatchException e) {
			System.out.println("Enter only the displayed numbers");
		}
		
		vishalAccount.SwitchOperations(selection, vishalAccount, amountValue, passwordvalue);
	}
	
	
}
