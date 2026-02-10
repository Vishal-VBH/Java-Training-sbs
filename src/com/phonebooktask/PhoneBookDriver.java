package com.phonebooktask;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhoneBookDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Contact> conctList = new ArrayList<Contact>();
        PhoneBook phonecontactbook = new PhoneBook(conctList);
        
        try {
        while (true) {
            System.out.println("\n===== PHONE BOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contact By Name");
            System.out.println("5. View Contact By Number");
            System.out.println("6. Exit");
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

                    Contact contact = new Contact(number, name);
                    phonecontactbook.addContact(contact);
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    phonecontactbook.viewAllContact();
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();
                    phonecontactbook.deleteContact(deleteName);
                    break;
                    
                case 4:
                	System.out.println("Enter the Name to find the contact: ");
                	String contName = sc.nextLine();
                	phonecontactbook.viewContactByName(contName);
                	break;
                	
                case 5:
                	System.out.println("Enter the Number to find the contact: ");
                	String contNumber = sc.nextLine();
                	phonecontactbook.viewContactByName(contNumber);
                	break;

                case 6:
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
