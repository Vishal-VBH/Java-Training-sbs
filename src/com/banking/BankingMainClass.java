package com.banking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingMainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankingOperations vishalAccount = null;

        // Account creation (runs once)
        while (vishalAccount == null) {
            try {
                System.out.println("Enter the Account number:");
                int accountNumber = sc.nextInt();

                System.out.println("Enter the Name of the Account Holder:");
                String holderName = sc.next();

                System.out.println("Set the Password for your account and remember it:");
                String password = sc.next();

                System.out.println("Enter the minimum Balance:");
                double minimumAmount = sc.nextDouble();

                vishalAccount = new BankingOperations(accountNumber, holderName, password, minimumAmount);

            } catch (InputMismatchException e) {
                System.err.println("❌ Enter only valid number values!");
                sc.nextLine(); // clear invalid input
            }
        }

        boolean running = true;

        // Menu loop (runs continuously)
        while (running) {
            try {
                System.out.println("\nChoose any one of the operations....");
                System.out.println("1. Add Balance");
                System.out.println("2. Withdraw Balance");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int selection = sc.nextInt();

                if (selection == 3) {
                    System.out.println("Thank you! Exiting...");
                    running = false;
                    break;
                }

                System.out.println("Enter the amount:");
                double amountValue = sc.nextDouble();

                System.out.println("Please enter the Password:");
                String passwordValue = sc.next();

                vishalAccount.SwitchOperations(selection, vishalAccount, amountValue, passwordValue);

            } catch (InputMismatchException e) {
                System.err.println("❌ Enter only the displayed numbers!");
                sc.nextLine(); // clear invalid input
            }
        }

        sc.close();
    }
}
