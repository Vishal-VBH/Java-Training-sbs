package com.collections.map;

import java.util.Map;

public class PhoneBook {

	Map<Long , String> contactMap ; //till client need why to create object ?

	public PhoneBook(Map<Long , String> contactMap ) {
		super();
		this.contactMap = contactMap;
	}
	//to add a contact
	public void addContact(Long phoneNumber , String name) {
		contactMap.put(phoneNumber , name);
		System.out.println("Successfully added "+name+" to the phoneBook");
	}
	
	//to delete a contact
	public void deleteContact(Long contactNumber) {
		System.out.println("Removing from the phonebook");
		contactMap.remove(contactNumber);
		System.out.println("Sucessfully removed the contact");
		System.out.println();
	}
	
	// to view a contact by number
	public void viewContactByNumber(long number) {
		System.out.println();
	    System.out.println("Viewing the phonebook");
	    System.out.println( number + " : " + contactMap.get(number));
	    
	}

	
	//view all contacts
	public void viewAllContact() {
		System.out.println();
		System.out.println("Viewing all the phonebook's Contacts");
		System.out.println();
		for(Map.Entry<Long, String> entry : contactMap.entrySet()) {
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
		
	}
	
}
