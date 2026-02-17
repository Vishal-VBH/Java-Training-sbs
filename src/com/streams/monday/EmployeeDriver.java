package com.streams.monday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class EmployeeDriver {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(new Employee(1, "vishal", 15000 , 23 , "SDE"),
											   new Employee(7, "raushan", 14000 , 24 , "SDE"),
											   new Employee(2, "adam", 1200, 21 ,"Finance"),
											   new Employee(3, "john", 1300 ,19 , "HR"),
											   new Employee(4, "soundarya", 17000 , 34 , "Director"),
											   new Employee(5, "nikhil", 1000 , 31 , "Developer"));
		
		//printing the second highest salaried employee
		System.out.println(
		empList.stream().sorted(Comparator.comparing(Employee :: getEmpSalary).reversed()).skip(1).findFirst()
		);
		//find oldest employee
		System.out.println(
				empList.stream().sorted(Comparator.comparing(Employee :: getEmpAge).reversed()).findFirst()
				);
		
		//count employees in each department
		System.out.println(
				empList.stream().collect(Collectors.groupingBy(Employee :: getDepartment , Collectors.counting()))
				);
		//aveerage of each dept
		System.out.println(
				empList.stream().collect(Collectors.groupingBy(Employee :: getDepartment , Collectors.averagingDouble(Employee :: getEmpSalary)))
				);

		//avg of salary
		System.out.println(empList.stream().collect(Collectors.averagingDouble(Employee :: getEmpSalary)));
		
		double average = empList.stream().collect(Collectors.averagingDouble(Employee::getEmpSalary));

		empList.stream().filter(emp -> emp.getEmpSalary() > average).forEach(System.out::println);
		
		System.out.println("-----------------");
		System.out.println("sort by department and then by salary descending");
		//sort by department and then by salary descending
		empList.stream().sorted(Comparator.comparing(Employee :: getDepartment).thenComparing(Employee :: getEmpSalary)).forEach(System.out::println);

	}
}
