package com.controller.bootweb.demo.gof23.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 观察者类
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received custom event: " + event.getMessage());
    }
}
