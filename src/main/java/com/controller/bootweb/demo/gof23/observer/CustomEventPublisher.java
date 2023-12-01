package com.controller.bootweb.demo.gof23.observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

// 事件发布者类
@Component
public class CustomEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishCustomEvent(String message) {
        CustomEvent customEvent = new CustomEvent(this, message);
        eventPublisher.publishEvent(customEvent);
    }
}
