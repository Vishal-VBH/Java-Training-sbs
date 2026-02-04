package StringManipulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopProducts {

	private static String searchProduct(String searchingInput , String[] prodStrings) {
		
	        for (String eachWord : prodStrings) {
	           if(eachWord.equals(searchingInput)){
	        	   return searchingInput + " product is available in the shop";
	           }
	        }
			return "Sorry, the product is not available in this shop";

	}
	
	public static void main(String[] args) {
		try {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of products you going to adding.....");
		int numberOfProducts=sc.nextInt();
		String[] products = new String[numberOfProducts];
		
		for(int i=0 ; i<products.length ; i++) {
		System.out.println("Enter the products number - " + (i+1));
		String productInput = sc.next();
		
		products[i]=productInput;
		
		}
		System.out.println("The products added are.....");
		for(String str : products) {
			System.out.println(str);
		}
		
		System.out.println("Press 1 if you want to Search for product");
		int opted =sc.nextInt();
		switch (opted) {
		case 1: {
			System.out.println("Enter the product you want to search..(be specific regarding spelling..)");
			String searchingInput = sc.next();
			System.out.println(searchProduct(searchingInput , products));
			break;
			
		}
		default:
			System.out.println("Please provide valid input");
		}
		}catch (InputMismatchException e) {
			System.out.println("Please enter valid input...");
		}
	}

}
