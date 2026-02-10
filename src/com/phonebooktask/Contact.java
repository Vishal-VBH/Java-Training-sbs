package com.phonebooktask;

public class Contact {

	private long phoneNumber;
	private String contactname;
	
	
	public Contact(long phoneNumber, String contactname) {
		super();
		this.phoneNumber = phoneNumber;
		this.contactname = contactname;
	}
	
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}


	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phoneNumber + ", contactname=" + contactname + "]";
	}
	
}
