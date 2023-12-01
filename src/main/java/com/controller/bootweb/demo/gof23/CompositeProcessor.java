package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.adapter.Adapter;
import com.controller.bootweb.demo.gof23.composite.Component;
import com.controller.bootweb.demo.gof23.composite.Composite;
import com.controller.bootweb.demo.gof23.composite.Leaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CompositeProcessor {

    @Autowired
    ApplicationContext context;

    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 创建叶子节点
            Component leaf1 = new Leaf("Leaf1");
            Component leaf2 = new Leaf("Leaf2");

            // 创建组合节点，并添加叶子节点
            Composite composite = new Composite();
            composite.add(leaf1);
            composite.add(leaf2);

            // 调用组合节点的操作，实际上会递归调用叶子节点的操作
            composite.operation();
        };
    }
}
