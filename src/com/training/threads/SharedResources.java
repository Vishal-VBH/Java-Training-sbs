package com.training.threads;

public class SharedResources {

	private volatile int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public synchronized void producer(int produce){
		while (data >= 100) { 
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

			System.out.println(Thread.currentThread().getName()+ " is producing " + produce);
			data= data + produce;
			System.out.println("Total updated Value : "+ data);
			System.out.println();
			notifyAll();
	}

	public synchronized void consumer(int consume){
		 while (data < consume) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+ " is consuming " + consume);
			data = data - consume;
			System.out.println("Remaining Value : "+ data);
			System.out.println();
			notifyAll();
	}
}
