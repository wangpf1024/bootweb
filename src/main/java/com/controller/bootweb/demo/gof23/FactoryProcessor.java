package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.factory.Computer;
import com.controller.bootweb.demo.gof23.factory.ComputerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class FactoryProcessor {


    //@Bean
    public CommandLineRunner run2(@Qualifier("highEndComputerFactory") ComputerFactory highEndFactory,
                                  @Qualifier("lowEndComputerFactory") ComputerFactory lowEndFactory) {
        return args -> {
            // 使用高配电脑工厂创建电脑对象
            Computer highEndComputer = highEndFactory.createComputer();
            System.out.println("High End Computer: " + highEndComputer.getProcessor() + ", " +
                    highEndComputer.getMemory() + ", " + highEndComputer.getHardDisk());

            // 使用低配电脑工厂创建电脑对象
            Computer lowEndComputer = lowEndFactory.createComputer();
            System.out.println("Low End Computer: " + lowEndComputer.getProcessor() + ", " +
                    lowEndComputer.getMemory() + ", " + lowEndComputer.getHardDisk());
        };
    }
}
