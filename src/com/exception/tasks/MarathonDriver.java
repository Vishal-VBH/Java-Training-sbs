package com.exception.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MarathonDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MarathonRegister registerCandidate;

        String candidateName;
        int age;
        String genderOfCandidate;
        String phoneContact;

        try {

            System.out.println();
            System.out.println("------Registration Begins------");
       while (true) {
                System.out.println("Enter the name of the candidate : ");
                System.out.println("(Minimum 4 Characters..)");
                candidateName = sc.nextLine();

                if (candidateName.length() >= 4) { 
                	break;
                }
                System.err.println("Please enter minimum 4 characters...");
            }

            while (true) {
              System.out.println("Enter the age of the candidate ");
              age = sc.nextInt();
                if (age >= 18 && age <= 60) {
                	break;
                }
                System.err.println("Please enter the age between 18-60 only...");
            }

            while (true) {
              System.out.println("Enter the Gender of the candidate ");
              genderOfCandidate = sc.next();
              if (genderOfCandidate.equalsIgnoreCase("Male")  || genderOfCandidate.equalsIgnoreCase("Female")
                        || genderOfCandidate.equalsIgnoreCase("Others")) {
            	  break;
              }
                System.err.println("Allowed Genders are : Male - Female - Others");
            }

            while (true) {
              System.out.println("Please Enter the 10 digit Contact number ");
               phoneContact = sc.next();
               if (phoneContact.matches("\\d{10}")) {
                	break;
                }

                System.err.println("please provide valid 10 digits contact number");
            }

            registerCandidate = new MarathonRegister(candidateName, age, genderOfCandidate, phoneContact);

            System.out.println();
           System.out.println("Candidate registered Successfull.... Here are the details....");
           System.out.println("Candidate Name : " + registerCandidate.getName());
           System.out.println("Candidate Age : " + registerCandidate.getAge());
           System.out.println("Candidate Contact : " + registerCandidate.getContact());
            System.out.println("Candidate Gender : " + registerCandidate.getGender());

        } catch (InputMismatchException | NullPointerException e) {
            System.err.println("Please enter the valid Input....");
        }
    }
}
