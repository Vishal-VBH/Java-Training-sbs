package com.training.threads;

public class ProducerConsumerDriver {

    public static void main(String[] args) {

        SharedResources resources = new SharedResources();

        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resources.producer(100);
            }
        }, "Producer Thread");

        Thread consumerThread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                resources.consumer(20);
            }
        }, "Consumer Thread-1");

        Thread consumerThread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                resources.consumer(25);
            }
        }, "Consumer Thread-2");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
