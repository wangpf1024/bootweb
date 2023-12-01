package com.controller.bootweb.demo.gof23.template;

// 抽象类
public abstract class AbstractOrderProcessor {

    // 模板方法
    public final void processOrder() {
        validateOrder();
        handlePayment();
        dispatch();
    }

    // 抽象方法，需要由子类实现
    protected abstract void validateOrder();

    protected abstract void handlePayment();

    protected abstract void dispatch();
}
