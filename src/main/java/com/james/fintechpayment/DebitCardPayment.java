package com.james.fintechpayment;

import java.util.UUID;

public class DebitCardPayment implements PaymentMethod {
    private double balance;

    public DebitCardPayment(double balance) {
        this.balance = balance;
    }

    @Override
    public Receipt processPayment(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for debit card payment.");
        }
        balance = amount;
        return new Receipt(UUID.randomUUID().toString(), amount, "Debit Card");
    }
}