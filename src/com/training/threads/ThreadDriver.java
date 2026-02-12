package com.training.threads;

public class ThreadDriver {

	public static void main(String[] args) {
		
//		NumberThread thread1 =  new NumberThread();
//		Thread t1= new Thread(thread1);
//		t1.setName("thread-1");
//		
		
		//Runnable type reference variable
		Runnable n1 = () -> {
			for(int i=1 ;i<=10 ;i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println("Current Running Thread : Multiple of 2 :-"+Thread.currentThread().getName()+"--"+ 2*i);
			}
		};
		
		
		//Runnable type reference variable
				Runnable n2 = () -> {
					for(int i=1 ;i<=10 ;i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println("Current Running Thread : Multiple of 2 :-"+Thread.currentThread().getName()+"--"+ 5*i);
					}
				};
		
		Thread t1= new Thread(n1, "Thread-1");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2= new Thread(n2, "Thread-2");
		t2.start();


}
}
