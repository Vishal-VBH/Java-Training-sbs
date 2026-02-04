package project.array;

import java.util.Scanner;

public class Sizer {
public static void main(String[] args) {
	
//	int[][] studentsMarks={{1,2,3,4},{21,32,34,44},{21,22,33,34}};	
//	System.out.println(studentsMarks.length); //3
//	System.out.println(studentsMarks[2][1]);
	Scanner sc = new Scanner(System.in);
	
	System.out.println("ENter  the number of students : ");
	int numberofstudents=sc.nextInt();
	System.out.println("ENter  the number of subjects : ");
	int numberofsubjects=sc.nextInt();
	
	
	int[][] studentsMarks = new int[numberofstudents][numberofsubjects];


	for (int studentNumber = 0; studentNumber < numberofstudents; studentNumber++) {
	    System.out.println("Enter marks for Student " + (studentNumber + 1));

	    for (int subjects = 0; subjects < numberofsubjects; subjects++) {
	        System.out.print("--Subject-- " + (subjects + 1) + ":- ");
	        studentsMarks[studentNumber][subjects] = sc.nextInt();
	    }
	}
	
	for (int student = 0; student < numberofstudents; student++) {
	    int sum = 0;

	    for (int subject = 0; subject < numberofsubjects; subject++) {
	        sum += studentsMarks[student][subject];
	    }

	    System.out.println("Total marks for Each student--" + (student + 1) + " - " + sum);
}	

}
}
