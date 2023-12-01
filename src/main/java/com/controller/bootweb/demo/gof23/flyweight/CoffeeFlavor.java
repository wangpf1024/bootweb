package com.controller.bootweb.demo.gof23.flyweight;

// 具体享元类
public class CoffeeFlavor implements Coffee {
    private final String flavor;

    public CoffeeFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void serveCoffee() {
        System.out.println("Serving coffee flavor '" + flavor + "'");
    }
}
