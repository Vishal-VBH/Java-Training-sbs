package com.insurance.management;

import java.util.List;

public class InsurancePolicyDetail {

	private String policyNumber;
	private String policyHolderName;
	private int age;
	private final double BASE_PREMIUM_AMOUNT = 100 ;
	private policyType policyType;
	private policyStatus policyStatus;
	
	private List<InsurancePolicyDetail> detailsList ;
	
	public enum policyType{
		HEALTH,
		LIFE,
		VEHICLE,
		TRAVEL
	}
	
	public enum policyStatus{
		ACTIVE, EXPIRED
	}

	public InsurancePolicyDetail(String policyNumber, String policyHolderName, int age , policyType policyType , policyStatus policyStatus) {
		super();
		this.policyNumber = policyNumber;
		this.policyHolderName = policyHolderName;
		this.age = age;
		this.policyType = policyType;
		this.policyStatus = policyStatus;
	}

	public InsurancePolicyDetail(List<InsurancePolicyDetail> detailsList) {
		this.detailsList = detailsList;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
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

	public double getBASE_PREMIUM_AMOUNT() {
		return BASE_PREMIUM_AMOUNT;
	}
	
	public double calculatePremiumRates(String policyNumber) throws InvalidPolicyTypeException {

	    for (InsurancePolicyDetail insurancePolicyDetail : detailsList) {
	        if (insurancePolicyDetail.getPolicyNumber().equals(policyNumber)) {

	            switch (insurancePolicyDetail.policyType) {
	                case HEALTH:
	                    return BASE_PREMIUM_AMOUNT + (BASE_PREMIUM_AMOUNT * 0.20);
	                case LIFE:
	                    return BASE_PREMIUM_AMOUNT + (BASE_PREMIUM_AMOUNT * 0.35);
	                case TRAVEL:
	                    return BASE_PREMIUM_AMOUNT + (BASE_PREMIUM_AMOUNT * 0.10);
	                case VEHICLE:
	                    return BASE_PREMIUM_AMOUNT + (BASE_PREMIUM_AMOUNT * 0.15);
	                default:
	                    throw new InvalidPolicyTypeException();
	            }     }
	  }

	    System.err.println("The Policy Number does not exist");
	    return 0;
	}
	
	public boolean addPolicy(String policyNumber, String policyHolderName, int age , policyType policyType , policyStatus policyStatus) {
		
		 for (InsurancePolicyDetail policy : detailsList) {
		        if (policy.getPolicyNumber().equals(policyNumber)) {
		            System.err.println("Policy with number " + policyNumber + " already exists!");
		            return false;
		        }
		    }
		detailsList.add(new InsurancePolicyDetail(policyNumber,policyHolderName,age , policyType , policyStatus));
		return true;
	}
	
	@Override
	public String toString() {
		return "InsurancePolicyDetail [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName
				+ ", age=" + age + ", BASE_PREMIUM_AMOUNT=" + BASE_PREMIUM_AMOUNT + ", policyType=" + policyType
				+ ", policyStatus=" + policyStatus +  "]";
	}

	public InsurancePolicyDetail findPolicy(String policyNumber) {

	    for (InsurancePolicyDetail policy : detailsList) {
	        if (policy.getPolicyNumber().equals(policyNumber)) {
	            return policy;
	        }
	    }
	    System.err.println("Policy with number " + policyNumber + " not found.");
	    return null;
	}
	
	public void getAllPolicies() {
		   if (detailsList.isEmpty()) {
		        System.out.println("No policies available.");
		        return;
		    }
	    for (InsurancePolicyDetail policy : detailsList) {
	            System.out.println(policy);
	    }
	}
	
	public void groupWisePolicies() {
	    if (detailsList.isEmpty()) {
	        System.out.println("No policies available to group.");
	        return;
	   }
	    int healthCount = 0;
	    int lifeCount = 0;
	    int vehicleCount = 0;
	    int travelCount = 0;

	    for (InsurancePolicyDetail policy : detailsList) {
	        switch (policy.policyType) {
	            case HEALTH:
	                healthCount++;
	                break;
	            case LIFE:
	                lifeCount++;
	                break;
	            case VEHICLE:
	                vehicleCount++;
	                break;
	            case TRAVEL:
	                travelCount++;
	                break;
	        }
	    }
	    System.out.println();
	    System.out.println("-- Group Wise Policy Count ---");
	    System.out.println("HEALTH  : " + healthCount);
	    System.out.println("LIFE    : " + lifeCount);
	    System.out.println("VEHICLE : " + vehicleCount);
	    System.out.println("TRAVEL  : " + travelCount);
	}	

	
}
