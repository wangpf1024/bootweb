package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.prototype.ComputerPrototype;
import com.controller.bootweb.demo.gof23.prototype.HighEndComputerPrototype;
import com.controller.bootweb.demo.gof23.prototype.LowEndComputerPrototype;
import com.controller.bootweb.demo.gof23.singleton.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SingletonProcessor {

    @Autowired
    ApplicationContext context;
    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 获取 Singleton 单例对象
            Singleton singleton1 = Singleton.getInstance();
            Singleton singleton2 = Singleton.getInstance();

            // 输出是否为同一个对象
            System.out.println("Is singleton1 the same as singleton2? " + (singleton1 == singleton2));

            // 获取 Singleton 单例对象，并调用 showMessage 方法
            Singleton singleton = context.getBean(Singleton.class);
            singleton.showMessage();
        };
    }

}
