package com.customer.call;

public class CallRequest {

    private int requestId;
    private Customer customer;
    private int minutes;

    public CallRequest(int requestId, Customer customer, int minutes) {
        this.requestId = requestId;
        this.customer = customer;
        this.minutes = minutes;
    }

    public int getRequestId() {
        return requestId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getMinutes() {
        return minutes;
    }
}
