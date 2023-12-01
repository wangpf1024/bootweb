package com.controller.bootweb.demo.gof23.factory;

import org.springframework.stereotype.Service;

// 具体产品B - 低配电脑
@Service("lowEndComputer")
public class LowEndComputer implements Computer {
    @Override
    public String getProcessor() {
        return "Intel i3";
    }

    @Override
    public String getMemory() {
        return "8GB DDR4";
    }

    @Override
    public String getHardDisk() {
        return "500GB HDD";
    }
}