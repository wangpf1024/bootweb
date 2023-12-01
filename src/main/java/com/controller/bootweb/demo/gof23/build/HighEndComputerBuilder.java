package com.controller.bootweb.demo.gof23.build;

import org.springframework.stereotype.Service;

// 具体构造器A - 高配电脑构造器
@Service("highEndComputerBuilder")
public class HighEndComputerBuilder implements ComputerBuilder {
    private String processor;
    private String memory;
    private String hardDisk;

    public HighEndComputerBuilder() {
        // 初始化默认值或使用配置
        this.processor = "Intel i9";
        this.memory = "32GB DDR4";
        this.hardDisk = "1TB SSD";
    }

    @Override
    public Computer build() {
        return new Computer(processor, memory, hardDisk);
    }
}

