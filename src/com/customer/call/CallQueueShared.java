package com.customer.call;

import java.util.LinkedList;
import java.util.Queue;

public class CallQueueShared {

    private Queue<CallRequest> queue = new LinkedList<>();

    public synchronized void addCall(CallRequest request) {
        queue.add(request);
        System.out.println(Thread.currentThread().getName() +
                " added call request: " + request.getRequestId());
        notifyAll();
    }

    public synchronized CallRequest processCall() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
