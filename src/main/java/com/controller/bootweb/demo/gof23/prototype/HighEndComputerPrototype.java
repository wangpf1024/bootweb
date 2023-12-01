package com.controller.bootweb.demo.gof23.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 具体原型A - 高配电脑原型
@Component
@Scope("prototype")
public class HighEndComputerPrototype implements ComputerPrototype {
    private String processor;
    private String memory;
    private String hardDisk;

    public HighEndComputerPrototype() {
        // 初始化默认值或使用配置
        this.processor = "Intel i9";
        this.memory = "32GB DDR4";
        this.hardDisk = "1TB SSD";
    }

    @Override
    public ComputerPrototype clonePrototype() {
        return new HighEndComputerPrototype();
    }

    @Override
    public String getConfiguration() {
        return "High End Computer: " + processor + ", " + memory + ", " + hardDisk;
    }
}

