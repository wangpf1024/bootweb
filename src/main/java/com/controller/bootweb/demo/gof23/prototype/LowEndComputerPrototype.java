package com.controller.bootweb.demo.gof23.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 具体原型B - 低配电脑原型
@Component
@Scope("prototype")
public class LowEndComputerPrototype implements ComputerPrototype {
    private String processor;
    private String memory;
    private String hardDisk;

    public LowEndComputerPrototype() {
        // 初始化默认值或使用配置
        this.processor = "Intel i3";
        this.memory = "8GB DDR4";
        this.hardDisk = "500GB HDD";
    }

    @Override
    public ComputerPrototype clonePrototype() {
        return new LowEndComputerPrototype();
    }

    @Override
    public String getConfiguration() {
        return "Low End Computer: " + processor + ", " + memory + ", " + hardDisk;
    }
}
