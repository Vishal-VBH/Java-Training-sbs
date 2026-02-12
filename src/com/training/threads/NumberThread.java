package com.training.threads;

public class NumberThread implements Runnable{

	@Override
	public void run() {
		for(int i=0 ; i<=5 ;i++) {
			System.out.println("Current Thread Running : "+ Thread.currentThread().getName()+"-"+ i );
			
		}
		
	}

}
