package StringManipulation;

import java.util.Scanner;

public class MultipleWordsString {

	  public static void main(String[] args) {
		  
		  	Scanner sc=new Scanner(System.in);
		  	String inputString=sc.nextLine();
		  	

	        String[] strArray = inputString.split(" ");
	        String resultString = "";

	        for (String word : strArray) {
	           
	            String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
	            resultString += capitalized + " ";
	        }


	        System.out.println(resultString);
	    }

}
