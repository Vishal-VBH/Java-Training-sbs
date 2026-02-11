package com.lambatraining;

import java.util.function.DoubleFunction;


public class EmployeeDriver {
public static void main(String[] args) {
	
	
	Employee emp1 = new Employee(101 ,"vishal" ,100D);
	
	DoubleFunction<Double> revisedSal = (sal) -> (sal + (sal*0.15));
	
	emp1.setEmpSalary(revisedSal.apply(emp1.getEmpSalary()));
	System.out.println(emp1.getEmpSalary());
	
	System.out.println(emp1);
	
}
}
