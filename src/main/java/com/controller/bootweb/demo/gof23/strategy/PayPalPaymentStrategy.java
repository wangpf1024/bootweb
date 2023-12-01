package com.controller.bootweb.demo.gof23.strategy;
// 具体策略类 - PayPalPaymentStrategy
import org.springframework.stereotype.Component;

@Component("payPalPaymentStrategy")
public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

