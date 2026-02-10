package com.collections.map;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookDriver {

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       Map<Long , String> contactMap = new HashMap<Long, String>();
        PhoneBook phonecontactbook = new PhoneBook(contactMap);
        
        try {
        while (true) {
            System.out.println("\n===== PHONE BOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contact By Number");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    long number = sc.nextLong();
                    sc.nextLine();

                    //Contact contact = new Contact(number, name);
                    phonecontactbook.addContact(number , name);
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    phonecontactbook.viewAllContact();
                    break;

                case 3:
                    System.out.print("Enter Number to Delete: ");
                    Long deleteNumber = sc.nextLong();
                    phonecontactbook.deleteContact(deleteNumber);
                    break;
                    
                case 4:
                	System.out.println("Enter the Number to find the contact: ");
                	Long contNumber = sc.nextLong();
                	phonecontactbook.viewContactByNumber(contNumber);
                	break;

                case 5:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    } catch(InputMismatchException e) {
    	System.err.println("Please enter valid inputs");
    }
    }
}
