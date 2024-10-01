package com.james.fintechpayment;

public interface PaymentMethod {
    Receipt processPayment(double amount) throws InsufficientFundsException;
}
