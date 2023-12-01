package com.controller.bootweb.demo.gof23.adapter;

import org.springframework.stereotype.Service;

// 具体类B
@Service
public class ConcreteClassB implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteClassB is handling the request.");
    }
}
