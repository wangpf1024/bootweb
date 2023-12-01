package com.controller.bootweb.demo.gof23.decorator;
// 具体组件类 - Espresso
public class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
