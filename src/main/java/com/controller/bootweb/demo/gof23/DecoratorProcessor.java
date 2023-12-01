package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.composite.Component;
import com.controller.bootweb.demo.gof23.composite.Composite;
import com.controller.bootweb.demo.gof23.composite.Leaf;
import com.controller.bootweb.demo.gof23.decorator.Coffee;
import com.controller.bootweb.demo.gof23.decorator.Espresso;
import com.controller.bootweb.demo.gof23.decorator.MilkDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DecoratorProcessor {

    @Autowired
    ApplicationContext context;

    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 创建具体组件对象
            Coffee espresso = new Espresso();
            System.out.println("Espresso: " + espresso.getDescription() + ", Cost: $" + espresso.getCost());

            // 使用装饰器对组件进行功能增强
            Coffee milkCoffee = new MilkDecorator(espresso);
            System.out.println("Milk Coffee: " + milkCoffee.getDescription() + ", Cost: $" + milkCoffee.getCost());
        };
    }
}
