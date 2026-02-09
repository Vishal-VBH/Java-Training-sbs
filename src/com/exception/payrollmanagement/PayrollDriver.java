package com.exception.payrollmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollDriver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee[] employeeArray = new Employee[3];
        int index = 0;

        while (index < 3) {
            try {
                System.out.println("\nPlease enter the Employee id : ");
                String empId = sc.next();
                sc.nextLine();

                System.out.println("Please enter the Employee name : ");
                String empName = sc.nextLine();

                System.out.println("Please enter the Department : ");
                String empDepartment = sc.nextLine();

                System.out.println("Select as per the appropriate Employee Type :");
                System.out.println("1. Permanent Employee    2. Contractual Employee");
                int choice = sc.nextInt();

                if (choice == 1) {

                    double baseSalary;
                    while (true) {
                        try {
                            System.out.println("Please enter the Base Salary : ");
                            baseSalary = sc.nextDouble();
                            if (baseSalary <= 0) {
                                throw new InvalidSalaryException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Please enter a valid number for Base Salary.");
                            sc.nextLine();
                        } catch (InvalidSalaryException e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    double empHra;
                    while (true) {
                        try {
                            System.out.println("Please enter the HRA : ");
                            empHra = sc.nextDouble();
                            if (empHra <= 0) {
                                throw new InvalidSalaryException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Please enter a valid number for HRA.");
                            sc.nextLine();
                        } catch (InvalidSalaryException e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    PermanentEmployee permanentEmp =
                            new PermanentEmployee(empId, empName, empDepartment, baseSalary, empHra);

                    employeeArray[index++] = permanentEmp;

                    System.out.println("The final salary for Permanent Employee is : "
                            + permanentEmp.calculateSalary());

                } else if (choice == 2) {
                    double empHoursWorked;
                    while (true) {
                        try {
                            System.out.println("Please enter the Hours Worked : ");
                            empHoursWorked = sc.nextDouble();
                            if (empHoursWorked <= 0) {
                                throw new InvalidSalaryException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Please enter a valid number for Hours Worked.");
                            sc.nextLine();
                        } catch (InvalidSalaryException e) {
                            System.err.println(e.getMessage());
                    }
                    }

                    double empHourlyRate;
                    while (true) {
                        try {
                            System.out.println("Please enter the Hourly Rate : ");
                            empHourlyRate = sc.nextDouble();
                            if (empHourlyRate <= 0) {
                                throw new InvalidSalaryException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Please enter a valid number for Hourly Rate.");
                            sc.nextLine();
                        } catch (InvalidSalaryException e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    ContractualEmployee contractEmp =
                            new ContractualEmployee(empId, empName, empDepartment,
                                    empHoursWorked, empHourlyRate);

                    employeeArray[index++] = contractEmp;

                    System.out.println("The final salary for Contract Employee is : "
                            + contractEmp.calculateSalary());

                } else {
                    System.err.println("Invalid choice! Please select 1 or 2.");
                }

            } catch (InputMismatchException e) {
                System.err.println("Invalid input type! Please enter correct values.");
                sc.nextLine();
        }
        }

        System.out.println("\n====== Employee List ======");
        for (Employee emp : employeeArray) {
            System.out.println(emp);
        }

}
}
