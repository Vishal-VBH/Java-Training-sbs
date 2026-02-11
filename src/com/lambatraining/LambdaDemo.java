package com.lambatraining;

import java.util.function.BiFunction;


public class LambdaDemo {
	
public static void main(String[] args) {
	
	BiFunction<Integer, Integer , Integer > maxNum = (a,b) -> a > b ? a : b; 
	
	System.out.println(maxNum.apply(200, 201));
	
	
	System.out.println("-------------");
	MyFunctionalInterface mymax = (a,b) -> a > b ? a : b ;
	System.out.println(mymax.max(101, 410));
	
}
}
