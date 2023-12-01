package com.controller.bootweb.demo.gof23.factory;


import org.springframework.stereotype.Service;

// 具体工厂B - 低配电脑工厂
@Service("lowEndComputerFactory")
public class LowEndComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new LowEndComputer();
    }
}