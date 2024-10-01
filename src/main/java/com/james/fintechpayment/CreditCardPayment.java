package com.james.fintechpayment;

import java.util.UUID;

public class CreditCardPayment implements PaymentMethod {
    private double balance;

    public CreditCardPayment(double balance) {
        this.balance = balance;
    }

    @Override
    public Receipt processPayment(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for credit card payment.");
        }
        balance = amount;
        return new Receipt(UUID.randomUUID().toString(), amount, "Credit Card");
    }
}