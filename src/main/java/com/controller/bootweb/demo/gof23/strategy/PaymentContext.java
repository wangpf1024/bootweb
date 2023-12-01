package com.controller.bootweb.demo.gof23.strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 上下文类
@Component
public class PaymentContext {

    @Autowired
    @Qualifier("creditCardPaymentStrategy")
    private PaymentStrategy paymentStrategy;

    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

