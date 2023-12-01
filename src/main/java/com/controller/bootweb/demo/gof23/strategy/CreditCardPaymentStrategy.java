package com.controller.bootweb.demo.gof23.strategy;
// 具体策略类 - CreditCardPaymentStrategy
import org.springframework.stereotype.Component;

@Component("creditCardPaymentStrategy")
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

