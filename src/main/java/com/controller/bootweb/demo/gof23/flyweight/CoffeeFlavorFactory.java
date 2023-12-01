package com.controller.bootweb.demo.gof23.flyweight;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 享元工厂类
@Component
public class CoffeeFlavorFactory {
    private Map<String, Coffee> flavors = new HashMap<>();

    public Coffee getCoffeeFlavor(String flavorName) {
        return flavors.computeIfAbsent(flavorName, CoffeeFlavor::new);
    }
}
