package com.controller.bootweb.demo.gof23.composite;

import java.util.ArrayList;
import java.util.List;

// 组合节点类
public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite is performing operation.");
        for (Component component : children) {
            component.operation();
        }
    }
}

