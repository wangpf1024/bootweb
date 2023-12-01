package com.controller.bootweb.demo.gof23.build;

import org.springframework.stereotype.Service;

// 具体构造器B - 低配电脑构造器
@Service("lowEndComputerBuilder")
public class LowEndComputerBuilder implements ComputerBuilder {
    private String processor;
    private String memory;
    private String hardDisk;

    public LowEndComputerBuilder() {
        // 初始化默认值或使用配置
        this.processor = "Intel i3";
        this.memory = "8GB DDR4";
        this.hardDisk = "500GB HDD";
    }

    @Override
    public Computer build() {
        return new Computer(processor, memory, hardDisk);
    }
}
