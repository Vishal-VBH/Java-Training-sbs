package com.customer.call;

public class Customer {

    private int customerId;
    private String customerName;
    private long phoneNumber;
    private double walletBalance;

    private static final double CALL_RATE = 2.0; // ₹2 per minute

    public Customer(int customerId, String customerName, long phoneNumber, double walletBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.walletBalance = walletBalance;
    }

    public synchronized void makeCall(int minutes) {
        double cost = minutes * CALL_RATE;

        if (walletBalance < cost) {
            throw new InsufficientBalanceException("Insufficient balance for customer: " + customerName);
        }

        walletBalance -= cost;
        TelecomRevenue.addRevenue(cost);

        System.out.println(Thread.currentThread().getName() + " | " +
                customerName + " made call for " + minutes + " mins. ₹" + cost +
                " deducted. Remaining balance: ₹" + walletBalance);
    }

    public synchronized void recharge(double amount) {
        walletBalance += amount;
        System.out.println(Thread.currentThread().getName() + " | " +
                customerName + " recharged ₹" + amount + ". New balance: ₹" + walletBalance);
        notifyAll();
    }

    public synchronized double getBalance() {
        return walletBalance;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
