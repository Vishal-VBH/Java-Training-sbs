package com.phonebooktask;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

	List<Contact> contactList ; //till client need why to create object ?

	public PhoneBook(List<Contact> contactList) {
		super();
		this.contactList = contactList;
	}
	//to add a contact
	public void addContact(Contact contact) {
		contactList.add(contact);
		System.out.println("Successfully added "+contact.getContactname()+" to the phoneBook");
	}
	
	//to delete a contact
	public void deleteContact(String contactName) {
		System.out.println("Removing from the phonebook");
		for (Contact contact : contactList) {
			if(contact.getContactname().equalsIgnoreCase(contactName)) {
				contactList.remove(contact);
				System.out.println("Removed successfully..");
				break;
			}
		}
		for (Contact contact2 : contactList) {
			System.out.println(contact2.getContactname());
		}
	}
	
	//to view a contact by name
	public void viewContactByName(String name) {
		System.out.println("Viewing the phonebook");
		for (Contact contact : contactList) {
			if(contact.getContactname().equalsIgnoreCase(name)) {
				System.out.println(contact.getContactname() + " = "+ contact.getPhoneNumber());
			}
		}
	}
	
	// to view a contact by number
	public void viewContactByNumber(long number) {
	    System.out.println("Viewing the phonebook");
	    boolean found = false;
	    
	    for (Contact contact : contactList) {
	        if (contact.getPhoneNumber() == number) {
	            System.out.println(contact.getContactname() + " = " + contact.getPhoneNumber());
	            found = true;
	            break;
	        }
	    }
	    
	    if (!found) {
	        System.out.println("Contact not found with number: " + number);
	    }
	}

	
	//view all contacts
	public void viewAllContact() {
		System.out.println();
		System.out.println("Viewing all the phonebook's Contacts");
		System.out.println();
		for (Contact contact : contactList) {
			System.out.println(contact.getContactname()+" - "+contact.getPhoneNumber());
		}
		
	}
	
}
