package com.insurance;

public class VehicleInsurance implements InsuranceCompany {
	
	private String policyHolderName;
	private String vehicleType; //TwoWHeeler or FourWheeler
	private double vehicleValue;
	private double rate = 0.01;


	public VehicleInsurance(String policyHolderName, String vehicleType, double vehicleValue) {
		super();
		this.policyHolderName = policyHolderName;
		this.vehicleType = vehicleType;
		this.vehicleValue = vehicleValue;
	}



	public String getPolicyHolderName() {
		return policyHolderName;
	}



	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public double getVehicleValue() {
		return vehicleValue;
	}



	public void setVehicleValue(double vehicleValue) {
		this.vehicleValue = vehicleValue;
	}
	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public  static VehicleInsurance getVehicleInsurance (String policyHolderName, String vehicleType, double  vehicleValue) {
		
		return new VehicleInsurance(policyHolderName, vehicleType, vehicleValue);
			
	}

	@Override
	public double calculateAnnualPremium() {
		
		if(vehicleType.equals("TwoWheeler")) {
			double annualPremium = ( (2*rate) * vehicleValue );
			System.out.println("Your Vehicle premium amount is "+ annualPremium);
			return annualPremium ;
			
		}else if(vehicleType.equals("FourWheeler")){
			double annualPremium = ( (4*rate) * vehicleValue );
			System.out.println("Your premium amount is "+annualPremium);
			return annualPremium;
		}else {
			System.err.println("Invalid selection...");
			return 0;
		}
		
	}
	
	/**
	 * Vehicle Insurance Policy
Inputs
    Policy Holder Name
    Vehicle Type (TwoWheeler or FourWheeler)
    Vehicle Value
Premium Calculation Rules
    TwoWheeler
    Premium = 2% of vehicle value
    FourWheeler
Premium = 4% of vehicle value
	 */
}
