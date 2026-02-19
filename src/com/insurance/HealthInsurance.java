package com.insurance;

public class HealthInsurance implements InsuranceCompany {
	
	private String policyHolderName;
	private int age;
	private double basePremiumAmount = 10000;
	private double sumAssured;

	public HealthInsurance(String policyHolderName, int age , double sumAssured) {
		super();
		this.policyHolderName = policyHolderName;
		this.age = age;
		this.sumAssured=sumAssured;
		
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public double getBasePremiumAmount() {
		return basePremiumAmount;
	}
	
	public double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}
	
	public static HealthInsurance getHealthInsurance (String policyHolderName, int age, double sumAssured) {
		
		return new HealthInsurance(policyHolderName, age, sumAssured);
			
	}

	@Override
	public double calculateAnnualPremium() {

	    double annualPremium;

	    if (age > 45) {
	        annualPremium = basePremiumAmount + (0.20 * basePremiumAmount);
	        System.out.println("You come under Premium so here is your Annual Premium " + annualPremium);
	    } else {
	        annualPremium = basePremiumAmount;
	        System.out.println("Your Premium Amount is " + annualPremium);
	    }

	    return annualPremium;
	}
	
/***
 * ==============
Health Insurance Policy
Inputs
    Policy Holder Name
    Age (in years)
    sum assured - 5 lakh , 10 lakh 
Premium Calculation Rules
    If the policy holder’s age is greater than 45 years:
    Add 20% surcharge to the base premium
Otherwise:
    Premium remains the base premium
 */
	
}
