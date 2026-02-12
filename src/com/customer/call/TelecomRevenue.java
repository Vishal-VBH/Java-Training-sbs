package com.customer.call;

public class TelecomRevenue {

    private static double totalRevenue = 0;

    public static synchronized void addRevenue(double amount) {
        totalRevenue += amount;
    }

    public static synchronized double getTotalRevenue() {
        return totalRevenue;
    }
}
