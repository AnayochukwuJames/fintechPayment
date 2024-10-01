package com.james.fintechpayment;

import java.util.UUID;

public class DigitalWalletPayment implements PaymentMethod {
    private double balance;

    public DigitalWalletPayment(double balance) {
        this.balance = balance;
    }

    @Override
    public Receipt processPayment(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for digital wallet payment.");
        }
        balance = amount;
        return new Receipt(UUID.randomUUID().toString(), amount, "Digital Wallet");
    }
}