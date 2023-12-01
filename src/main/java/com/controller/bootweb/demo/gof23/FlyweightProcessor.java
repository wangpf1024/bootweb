package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.flyweight.Coffee;
import com.controller.bootweb.demo.gof23.flyweight.CoffeeFlavorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class FlyweightProcessor {

    @Autowired
    ApplicationContext context;

    @Autowired
    private CoffeeFlavorFactory flavorFactory;

    //@Bean
    public CommandLineRunner run() {
        return args ->  {
            // 客户端代码
            Coffee coffee1 = flavorFactory.getCoffeeFlavor("Cappuccino");
            coffee1.serveCoffee();

            Coffee coffee2 = flavorFactory.getCoffeeFlavor("Latte");
            coffee2.serveCoffee();

            // 再次服务相同的咖啡，实际上是共享了之前创建的享元对象
            Coffee coffee3 = flavorFactory.getCoffeeFlavor("Cappuccino");
            coffee3.serveCoffee();
        };
    }
}
