package com.james.fintechpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FintechPaymentApplication {

    public static void main(String[] args) {
        PaymentProcessingSystem paymentSystem = new PaymentProcessingSystem();

        PaymentMethod creditCard = new CreditCardPayment(1000.0);
        PaymentMethod debitCard = new DebitCardPayment(500.0); // This balance allows for insufficient funds
        PaymentMethod digitalWallet = new DigitalWalletPayment(1000.0);
        PaymentMethod bankTransfer = new BankTransferPayment(); // No argument needed

        paymentSystem.processPayment(creditCard, 1000); // Successful payment
        paymentSystem.processPayment(debitCard, 600);   // Insufficient funds
        paymentSystem.processPayment(digitalWallet, 1000); // Successful payment
        paymentSystem.processPayment(bankTransfer, 1000); // Successful payment

        paymentSystem.generateReport();
    }
}
