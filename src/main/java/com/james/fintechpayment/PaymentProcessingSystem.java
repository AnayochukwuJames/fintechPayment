package com.james.fintechpayment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentProcessingSystem {
    private final List<Receipt> receipts = new ArrayList<>();

    public void processPayment(PaymentMethod paymentMethod, double amount) {
        try {
            Receipt receipt = paymentMethod.processPayment(amount);
            receipts.add(receipt);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void generateReport() {
        Map<String, List<Receipt>> report = new HashMap<>();
        for (Receipt receipt : receipts) {
            report.computeIfAbsent(receipt.getPaymentMethod(), k -> new ArrayList<>()).add(receipt);
        }

        System.out.println("Daily Transaction Report:");
        for (Map.Entry<String, List<Receipt>> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " transactions");
            for (Receipt r : entry.getValue()) {
                System.out.println(r);
            }
        }
    }
}
