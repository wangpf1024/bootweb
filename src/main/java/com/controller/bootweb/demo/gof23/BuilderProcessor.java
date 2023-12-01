package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.build.Computer;
import com.controller.bootweb.demo.gof23.build.HighEndComputerBuilder;
import com.controller.bootweb.demo.gof23.build.LowEndComputerBuilder;
import com.controller.bootweb.demo.gof23.factory.ComputerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BuilderProcessor {

    //@Bean
    public CommandLineRunner run(@Qualifier("highEndComputerBuilder") HighEndComputerBuilder highEndBuilder, @Qualifier("lowEndComputerBuilder") LowEndComputerBuilder lowEndBuilder) {
        return args -> {
            // 使用高配电脑构造器创建电脑对象
            Computer highEndComputer = highEndBuilder.build();
            System.out.println("High End Computer: " + highEndComputer);

            // 使用低配电脑构造器创建电脑对象
            Computer lowEndComputer = lowEndBuilder.build();
            System.out.println("Low End Computer: " + lowEndComputer);
        };
    }
}
