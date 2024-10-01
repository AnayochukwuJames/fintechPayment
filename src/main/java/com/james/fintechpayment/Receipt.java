// Receipt.java
package com.james.fintechpayment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Receipt {
    private String transactionId;
    private double amount;
    private String paymentMethod;
}
