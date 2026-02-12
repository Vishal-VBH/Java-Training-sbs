package com.customer.call;

import java.util.Random;

public class TelecomProcesserDriver {

    public static void main(String[] args) {

        CallQueueShared callQueue = new CallQueueShared();
        Random random = new Random();

        Customer c1 = new Customer(101, "Vishal", 8088238703L, 20);
        Customer c2 = new Customer(102, "Rahul", 9876543210L, 15);
        Customer c3 = new Customer(103, "Anita", 9988776655L, 10);

        //Producer lambdas
        Thread producer1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                int minutes = random.nextInt(5) + 1;
                CallRequest request = new CallRequest(i, c1, minutes);
                callQueue.addCall(request);

                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-1");

        Thread producer2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                int minutes = random.nextInt(5) + 1;
                CallRequest request = new CallRequest(i, c2, minutes);
                callQueue.addCall(request);

                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-2");

        Thread producer3 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                int minutes = random.nextInt(5) + 1;
                CallRequest request = new CallRequest(i, c3, minutes);
                callQueue.addCall(request);

                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-3");

        // Consumer lambdas
        Thread consumer1 = new Thread(() -> {
            while (true) {
                CallRequest request = callQueue.processCall();
                try {
                    request.getCustomer().makeCall(request.getMinutes());
                } catch (InsufficientBalanceException e) {
                    System.out.println(Thread.currentThread().getName() + " | " + e.getMessage());
                }
            }
        }, "Consumer-1");

        Thread consumer2 = new Thread(() -> {
            while (true) {
                CallRequest request = callQueue.processCall();
                try {
                    request.getCustomer().makeCall(request.getMinutes());
                } catch (InsufficientBalanceException e) {
                    System.out.println(Thread.currentThread().getName() + " | " + e.getMessage());
                }
            }
        }, "Consumer-2");

        // Recharge lambda
        Thread rechargeThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                c3.recharge(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Recharge-Thread");

        // Start threads
        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();

        rechargeThread.start();
    }
}
