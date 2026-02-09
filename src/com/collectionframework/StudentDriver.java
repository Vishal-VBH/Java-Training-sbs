package com.collectionframework;

import java.util.Set;
import java.util.TreeSet;

public class StudentDriver {

	
	public static void main(String[] args) {
		
	
		Set<Student> studSet = new TreeSet<Student>(new StudentIdComparator());
		studSet.add(new Student(103, "Vishal", 23));
		studSet.add(new Student(105, "Akash", 22));
		studSet.add(new Student(104, "Prithvi", 24));
		studSet.add(new Student(101, "Prajwal", 25));
		studSet.add(new Student(102, "Ramesh", 28));
		studSet.add(new Student(106, "Mohit", 33));
		studSet.add(new Student(107, "Kamlesh", 28));
		
		for (Student student : studSet) {
			System.out.println(student.getStuId()+" = " + student.getStuName());
		}
		System.out.println("===============================");
		
		Set<Student> studAgeSet = new TreeSet<Student>(new StudentAgeComparator());
		studAgeSet.add(new Student(103, "Vishal", 23));
		studAgeSet.add(new Student(105, "Akash", 22));
		studAgeSet.add(new Student(104, "Prithvi", 24));
		studAgeSet.add(new Student(101, "Prajwal", 25));
		studAgeSet.add(new Student(102, "Ramesh", 28));
		
		for (Student student : studAgeSet) {
			System.out.println(student.getStuId()+" = " + student.getStuName());
		}
		
	}
}
