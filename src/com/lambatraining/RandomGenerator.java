package com.lambatraining;

import java.util.Random;
import java.util.function.Supplier;

public class RandomGenerator {

	public static void main(String[] args) {
		
		int random2 = (int) (Math.random()*1000000);
		
		Supplier<String> supInt = () -> String.format("%06d",random2);
		System.out.println(supInt.get());
		
		System.out.println("=============");
		
		
			Random randomNum = new Random();
			Supplier<String> randomOTP = () -> String.format("%06d", randomNum.nextInt(1000000));
			
			int i=1;
			while (i<=5) {
				System.out.println(randomOTP.get());
				i++;
			}
			
			
			
		
	}
}
