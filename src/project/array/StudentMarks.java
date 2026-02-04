package project.array;

import java.util.Scanner;

public class StudentMarks {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number of subjects");
		int size=sc.nextInt();
		
		int[] marks=new int[size];
		
		double average=0;
		for(int i=0; i<marks.length;i++) {
			System.out.println("Enter the mark for subject number = "+ (i+1));
			int mark = sc.nextInt();
			marks[i]=mark;
			
			average=average+mark;
			
		}
		System.out.println("Average of the marks are : "+ average/size);
	}
}
