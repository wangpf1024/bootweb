package com.controller.bootweb.demo.gof23.factory;

import org.springframework.stereotype.Service;

// 具体产品A - 高配电脑
@Service("highEndComputer")
public class HighEndComputer implements Computer {
    @Override
    public String getProcessor() {
        return "Intel i9";
    }

    @Override
    public String getMemory() {
        return "32GB DDR4";
    }

    @Override
    public String getHardDisk() {
        return "1TB SSD";
    }
}


