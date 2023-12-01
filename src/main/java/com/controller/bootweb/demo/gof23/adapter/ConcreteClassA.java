package com.controller.bootweb.demo.gof23.adapter;

// 具体类A
public class ConcreteClassA implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteClassA is handling the request.");
    }
}


