package com.controller.bootweb.demo.gof23.template;
// 具体类 - InStoreOrderProcessor
import org.springframework.stereotype.Component;

@Component
public class InStoreOrderProcessor extends AbstractOrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating in-store order...");
    }

    @Override
    protected void handlePayment() {
        System.out.println("Handling in-store payment...");
    }

    @Override
    protected void dispatch() {
        System.out.println("Dispatching in-store order...");
    }
}

