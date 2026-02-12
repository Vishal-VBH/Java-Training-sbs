package com.streams.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeStreams {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(new Employee(101, "Sourav", 10000D ,23),new Employee(103, "Ajay", 30000D, 25),
				new Employee(106, "Sunaina", 11000D , 20),new Employee(105, "vish", 10000D , 30),new Employee(104, "Sourav", 33000D, 27));
		
		empList.stream().filter((emp) -> emp.getEmpName()
											.startsWith("S"))
											.sorted(Comparator.comparing(Employee :: getEmpSal)
											.thenComparing(Employee :: getEmpId).reversed()).forEach(System.out::println); 
		
		
		System.out.println("=".repeat(30));
		System.out.println("Sal more than 5000");
		empList.stream().filter( e -> e.getEmpSal() > 5000).forEach(System.out::println);
		
		System.out.println(" Sorting by age ");
		empList.stream().sorted(Comparator.comparingInt(Employee :: getAge)).forEach(System.out::println);
		
		System.out.println(" Salary increment ");
		empList.stream().map((e) -> e.getEmpSal()*0.10).forEach(System.out::println);
		
		
		
	}
}
