package com.controller.bootweb.demo.gof23.observer;

import org.springframework.context.ApplicationEvent;

// 事件类
public class CustomEvent extends ApplicationEvent {

    private final String message;

    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

