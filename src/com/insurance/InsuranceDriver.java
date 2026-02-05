package com.insurance;

import java.util.Scanner;

public class InsuranceDriver {
	
	

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		InsuranceCompany insuranceSelected;
		while(true) {
			
			System.out.println("Enter for what type of Insurance you want to choose...");
			System.out.println("1.Health Insurance    2.Vehicle Insurance   3.Life Insurance  0.Exit");
			byte choice = sc.nextByte();
			
			
		switch (choice) {
		case 1: {
			System.out.println("Enter the name of the policy holder: ");
			String nameOfHolder= sc.next();
			
			System.out.println("Enter the sum to be Assured ");
			double sumAssured = sc.nextDouble();
			
			System.out.println("Enter the age of the Policy holder ");
			int policyTerms = sc.nextInt(); 
		
			
			insuranceSelected = HealthInsurance.getHealthInsurance(nameOfHolder,policyTerms, sumAssured);
			insuranceSelected.calculateAnnualPremium();
			break;
		}
		case 2:{
			System.out.println("Enter the name of the policy holder: ");
			String nameOfHolder= sc.next();
			
			System.out.println("Enter the type of the Vehicle--- T = TwoWheeler F = FourWheeler");
			String typeOfVehicle = "";
			char ch = sc.next().charAt(0);
			
			if(ch=='T' || ch=='t') {
				typeOfVehicle = "TwoWheeler";
			}else {
				typeOfVehicle = "FourWheeler";
			}
			
			System.out.println("Enter the Vehicle  value to be Assured ");
			double vehicleValue = sc.nextDouble();
			
			insuranceSelected = VehicleInsurance.getVehicleInsurance(nameOfHolder, typeOfVehicle, vehicleValue);
			insuranceSelected.calculateAnnualPremium();
			break;
		}
		case 3 :{
			System.out.println("Enter the name of the policy holder: ");
			String nameOfHolder= sc.next();
			
			System.out.println("Enter the age of the Policy holder ");
			int age = sc.nextInt(); 
			
			System.out.println("Enter the sum to be Assured ");
			double sumAssured = sc.nextDouble();
			
			insuranceSelected = LifeInsurance.getLifeInsurance(nameOfHolder,500000, 5);
			insuranceSelected.calculateAnnualPremium();
			break;
		}
		case 0 : {
            System.out.println("Thank you! We hope we will get in contact Soon...");
            return;  
		}
		default:
			System.err.println("Invalid selection...");
		}
	}
		
	}
}
