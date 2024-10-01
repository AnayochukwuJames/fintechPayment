package com.james.fintechpayment;

import java.util.UUID;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public Receipt processPayment(double amount) {
        return new Receipt(UUID.randomUUID().toString(), amount, "Bank Transfer");
    }
}