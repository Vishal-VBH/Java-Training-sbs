package com.exception.payrollmanagement;

public class ContractualEmployee implements Employee {

	
	private String  empId;   
	private String empName;
	private String department; 
	private double hoursWorked;
	private double hourlyRate;

	public ContractualEmployee(String empId, String empName, String department, double hoursWorked, double hourlyRate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	@Override
	public String toString() {
	    return "Contarctual EMployee [ID=" + empId +
	           ", Name=" + empName +
	           ", Dept=" + department +
	           ", Salary=" + calculateSalary() + "]";
	}


	@Override
	public double calculateSalary() {
		double finalAmount = hoursWorked * hourlyRate;
		double taxAmount =  ( 0.1 * finalAmount);
//		System.out.println("The total salary for the employee is : " + ( finalAmount - taxAmount) );
		return (finalAmount - taxAmount) ;
	}

}
