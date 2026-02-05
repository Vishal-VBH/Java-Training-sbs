package com.insurance;

public class LifeInsurance implements InsuranceCompany {

	
	private String policyHolderName;
	private double sumAssured;
	private int policyTerm;
	private double basePremiumAmount = 10000;
	
	private float rate = 0.05f;
	
	
	public LifeInsurance(String policyHolderName, double sumAssured, int policyTerm) {
		super();
		this.policyHolderName = policyHolderName;
		this.sumAssured = sumAssured;
		this.policyTerm = policyTerm;
	}
	


	public String getPolicyHolderName() {
		return policyHolderName;
	}



	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}



	public double getSumAssured() {
		return sumAssured;
	}



	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}



	public int getPloicyTerm() {
		return policyTerm;
	}



	public void setPloicyTerm(int ploicyTerm) {
		this.policyTerm = ploicyTerm;
	}
	
	public static  LifeInsurance getLifeInsurance (String policyHolderName, double sumAssured, int policyTerm) {
		
		return new LifeInsurance(policyHolderName, sumAssured, policyTerm);
			
	}


	@Override
	public double calculateAnnualPremium() {
		
        double annualPremium = (sumAssured * rate / policyTerm);
        System.out.println("Your premium amount is " + annualPremium);
		return annualPremium;
	}
	
/**
Life Insurance Policy
	Inputs
	    Policy Holder Name
	    Sum Assured
	    Policy Term (in years)
	Premium Calculation Rules
	    Annual premium is calculated based on:
	    Total coverage amount
	    Duration of the policy
A fixed rate of 5% is applied on the per-year coverage amount    
	**/
}
