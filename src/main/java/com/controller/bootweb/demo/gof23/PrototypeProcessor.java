package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.prototype.ComputerPrototype;
import com.controller.bootweb.demo.gof23.prototype.HighEndComputerPrototype;
import com.controller.bootweb.demo.gof23.prototype.LowEndComputerPrototype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PrototypeProcessor {

    @Autowired
    ApplicationContext context;
    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 获取高配电脑原型并输出配置信息
            ComputerPrototype highEndPrototype = context.getBean(HighEndComputerPrototype.class);
            System.out.println("High End Computer Prototype: " + highEndPrototype.getConfiguration());

            // 获取低配电脑原型并输出配置信息
            ComputerPrototype lowEndPrototype = context.getBean(LowEndComputerPrototype.class);
            System.out.println("Low End Computer Prototype: " + lowEndPrototype.getConfiguration());
        };
    }

}
