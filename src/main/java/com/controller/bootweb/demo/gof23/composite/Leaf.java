package com.controller.bootweb.demo.gof23.composite;

// 叶子节点类
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " is performing operation.");
    }
}
