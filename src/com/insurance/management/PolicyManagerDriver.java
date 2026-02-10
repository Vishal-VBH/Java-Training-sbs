package com.insurance.management;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.insurance.management.InsurancePolicyDetail.policyStatus;
import com.insurance.management.InsurancePolicyDetail.policyType;

public class PolicyManagerDriver {

	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        List<InsurancePolicyDetail> detailsList = new ArrayList<>();
	        try {
	        InsurancePolicyDetail manager = new InsurancePolicyDetail(detailsList);
	        while (true) {
	            System.out.println("\n====== Insurance Policy Management System ======");
	            System.out.println("1.Add Policy");
	            System.out.println("2.Find Policy");
	            System.out.println("3.Calculate Premium");
	            System.out.println("4.View All Policies");
	            System.out.println("5.Get Group By Policies and count");
	            System.out.println("6.Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter Policy Number: ");
	                    String pNum = sc.nextLine();

	                    System.out.print("Enter Policy Holder Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Age: ");
	                    int age = sc.nextInt();
	                    sc.nextLine();

	                    System.out.println("Select Policy Type or enter first alphabet: H - HEALTH or L - LIFE or V - VEHICLE or T - TRAVEL");
	                    String typeInput = sc.nextLine();

	                    policyType type = null;

	                    if (typeInput.equalsIgnoreCase("HEALTH") || typeInput.equalsIgnoreCase("H") ) {
	                        type = policyType.HEALTH;
	                        
	                    } else if (typeInput.equalsIgnoreCase("LIFE") || typeInput.equalsIgnoreCase("L")) {
	                        type = policyType.LIFE;
	                        
	                    } else if (typeInput.equalsIgnoreCase("VEHICLE") || typeInput.equalsIgnoreCase("V")) {
	                        type = policyType.VEHICLE;
	                        
	                    } else if (typeInput.equalsIgnoreCase("TRAVEL")|| typeInput.equalsIgnoreCase("T")) {
	                        type = policyType.TRAVEL;
	                        
	                    } else {
	                        System.err.println("Invalid Policy Type!");
	                        throw new InvalidPolicyTypeException();
	                    }

	                    System.out.println("Select Policy Status: A- ACTIVE / E- EXPIRED");
	                    String statusInput = sc.nextLine();

	                    policyStatus status = null;

	                    if (statusInput.equalsIgnoreCase("ACTIVE") || statusInput.equalsIgnoreCase("A")) {
	                        status = policyStatus.ACTIVE;
	                        
	                    } else if (statusInput.equalsIgnoreCase("EXPIRED") || statusInput.equalsIgnoreCase("E")) {
	                        status = policyStatus.EXPIRED;
	                        
	                    } else {
	                        System.err.println("Invalid Policy Status!");
	                    }

	                    boolean added = manager.addPolicy(pNum, name, age, type, status);
	                    if (added) {
	                        System.out.println("Policy added successfully!");
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter Policy Number to Find: ");
	                    String findNum = sc.nextLine();
	                    InsurancePolicyDetail found = manager.findPolicy(findNum);
	                    if (found != null) {
	                        System.out.println(found);
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter Policy Number for Premium Calculation: ");
	                    String calcNum = sc.nextLine();
	                    try {
	                        double premium = manager.calculatePremiumRates(calcNum);
	                        System.out.println("Calculated Premium: " + premium);
	                    } catch (InvalidPolicyTypeException e) {
	                        e.printStackTrace();
	                    }
	                    break;

	                case 4:
	                    manager.getAllPolicies();
	                    break;
	                case 5:
	                    manager.groupWisePolicies();
	                    break;

	                case 6:
	                    System.out.println("Exiting... Thank you!");
	                    System.exit(0);

	                default:
	                    System.err.println("Invalid Choice! Try again.");
	            }
	        }
	        }catch ( InvalidPolicyTypeException | InputMismatchException e) {
	        	System.out.println("Please enter the valid input");
	        }
	    }
	}