package com.lambda.payment;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PaymentDriver {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        try {
            
            int paymentId = random.nextInt(1_000_000);
            System.out.print("Enter payment amount: ");
            double amount = sc.nextDouble();

         
            Predicate<Double> isValidAmount = amt -> amt > 0;

            if (!isValidAmount.test(amount)) {
                throw new InvalidAmountException();
            }

            System.out.print("Payment status (TRUE/FALSE) or (T/F): ");
            String statusInput = sc.next();

            boolean status;

            if (statusInput.equalsIgnoreCase("T") || statusInput.equalsIgnoreCase("TRUE")) {
                status = true;
            } else if (statusInput.equalsIgnoreCase("F") || statusInput.equalsIgnoreCase("FALSE")) {
                status = false;
            } else {
                throw new InvalidAmountException("Invalid status.Please Enter only T/F or TRUE/FALSE.");
            }

           
            Payment payment = new Payment(paymentId, amount, status);

        
            Supplier<String> referencePayment = () -> "PhonePe-" + payment.getPaymentId() + "-" + (status ? "SUCCESS" : "FAILED");

           
            Consumer<String> log = ref -> System.out.println("LOG Payment created with Ref: " + ref);

            
            Function<Payment, String> receiptGenerator = (pay) -> pay.isPaymentStatus() ? pay.toString() : "Payment Failed. No receipt generated.";
            
            //invoke supplier
            String reference = referencePayment.get();
            //invoke consumer
            log.accept(reference);

            System.out.println();
            System.out.println("--- PAYMENT RECEIPT ---");
            //invoke Function
            System.out.println(receiptGenerator.apply(payment));

        } catch (InvalidAmountException | InputMismatchException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
