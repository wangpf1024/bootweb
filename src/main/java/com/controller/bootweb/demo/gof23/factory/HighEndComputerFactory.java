package com.controller.bootweb.demo.gof23.factory;

import org.springframework.stereotype.Service;

// 具体工厂A - 高配电脑工厂
@Service("highEndComputerFactory")
public class HighEndComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new HighEndComputer();
    }
}


