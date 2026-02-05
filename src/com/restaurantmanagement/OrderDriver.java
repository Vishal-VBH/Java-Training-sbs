package com.restaurantmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderDriver {
	public static void main(String[] args) {
		try {
		Scanner sc= new Scanner(System.in);
	while(true) {
			System.out.println();
			System.out.println("Enter for what type of Order you want to Select...");
			System.out.println("1.Cloud Kitchen    2.Grocery Order   3.Restaurant Order  0.Exit");
			byte choice = sc.nextByte();
			
			
		switch (choice) {
		case 1: {
			System.out.println("Thank you for choosing Cloud Kitchen ");
			System.out.println("Please Enter your name : ");
			String name=sc.next();
			
			System.out.println("Please Enter amount you are going to pay : ");
			double orderAmt=sc.nextDouble();
			
			System.out.println("Please Enter your delivery distance : ");
			int deliveryDist = sc.nextInt();
			
			Order order = new CloudKitchenOrder(name, orderAmt, deliveryDist);
			System.out.println();
			System.out.println("The final amount to be paid is " + order.calculateFinalAmount());
			System.out.println("The order details are given below : ");
			System.out.println(order.getOrderDetails());
			
			break;
		}
		case 2:{
			System.out.println("Thank you for choosing Grocery");
			System.out.println("Please Enter your name : ");
			String name=sc.next();
			
			System.out.println("Please Enter amount you are going to pay : ");
			double orderAmt=sc.nextDouble();
			
			System.out.println("Are you a Membership Holder ? ");
			boolean isLoyalMember = false;
			System.out.println("Press Y if you are a membership holder OR Press N if you are not !!" );
			char ch = sc.next().charAt(0);
			if(ch=='Y' || ch=='y') {
				isLoyalMember = true;
			}
			Order order  = new GroceryOrder(name, orderAmt, isLoyalMember);
			System.out.println();
			System.out.println("The final amount to be paid is " + order.calculateFinalAmount());
			System.out.println("The order details are given below : ");
			System.out.println(order.getOrderDetails());
			
			break;
		}
		case 3 :{
			System.out.println("");
			System.out.println("Thank you for choosing Restaurant:  ");
			System.out.println("Please Enter your name : ");
			String name=sc.next();
			
			System.out.println("Please Enter amount you are going to pay : ");
			double orderAmt=sc.nextDouble();
			Order order = new RestaurantOrder(name, orderAmt);
			System.out.println();
			System.out.println("The final amount to be paid is " + order.calculateFinalAmount());
			System.out.println("The order details are given below : ");
			System.out.println(order.getOrderDetails());
			
			break;
		}
		case 0 : {
            System.out.println("Thank you for Restaurant...");
            return;  
		}
		default:
			System.err.println("Invalid selection...");
		}
	}
		}catch (InputMismatchException e) {
			System.err.println("Please enter valid input..");
		}
		
	}

}
