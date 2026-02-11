package com.lambatraining;

import java.util.Random;
import java.util.function.Supplier;

public class RandomGenerator {

	public static void main(String[] args) {
			Random randomNum = new Random();
			Supplier<String> randomOTP = () -> String.format("%06d", randomNum.nextInt(1000000));
			
			int i=1;
			while (i<=5) {
				System.out.println(randomOTP.get());
				i++;
			}
			
			
			
		
	}
}
