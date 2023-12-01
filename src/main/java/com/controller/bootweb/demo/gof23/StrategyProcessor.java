package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.observer.CustomEventPublisher;
import com.controller.bootweb.demo.gof23.strategy.CreditCardPaymentStrategy;
import com.controller.bootweb.demo.gof23.strategy.PayPalPaymentStrategy;
import com.controller.bootweb.demo.gof23.strategy.PaymentContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StrategyProcessor {

    @Autowired
    private PaymentContext paymentContext;
    @Autowired
    @Qualifier("creditCardPaymentStrategy")
    private CreditCardPaymentStrategy creditCardPaymentStrategy;
    @Autowired
    @Qualifier("payPalPaymentStrategy")
    private PayPalPaymentStrategy payPalPaymentStrategy;
    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 默认使用 Credit Card 支付
            paymentContext.processPayment(100);
            // 切换策略为 PayPal 支付
            paymentContext.setPaymentStrategy(payPalPaymentStrategy);
            paymentContext.processPayment(50);
        };
    }
}
