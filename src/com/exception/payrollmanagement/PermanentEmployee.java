package com.exception.payrollmanagement;

public class PermanentEmployee implements Employee{

		private String empId;   
		private String empName;
		private String department;      
		private double baseSalary;
		private double employeeHra;
		
	public PermanentEmployee(String empId, String empName, String department, double baseSalary,
				double employeeHra) {
			
			this.empId = empId;
			this.empName = empName;
			this.department = department;
			this.baseSalary = baseSalary;
			this.employeeHra = employeeHra;
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

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getEmployeeHra() {
		return employeeHra;
	}
	public void setEmployeeHra(double employeeHra) {
		this.employeeHra = employeeHra;
	}
	
	@Override
	public String toString() {
	    return "PermanentEmployee [ID=" + empId +
	           ", Name=" + empName +
	           ", Dept=" + department +
	           ", Salary=" + calculateSalary() + "]";
	}


	@Override
	public double calculateSalary() {
		double finalAmount = baseSalary + employeeHra;
//		System.out.println("The Total Salary of the employee is : " + finalAmount);
		return finalAmount;
	}
	

}
