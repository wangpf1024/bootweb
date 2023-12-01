package com.controller.bootweb.demo.gof23.template;

// 具体类 - OnlineOrderProcessor
import org.springframework.stereotype.Component;

@Component
public class OnlineOrderProcessor extends AbstractOrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating online order...");
    }

    @Override
    protected void handlePayment() {
        System.out.println("Handling online payment...");
    }

    @Override
    protected void dispatch() {
        System.out.println("Dispatching online order...");
    }
}
