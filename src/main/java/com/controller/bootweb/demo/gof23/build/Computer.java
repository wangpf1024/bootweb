package com.controller.bootweb.demo.gof23.build;

// 产品类 - 电脑
public class Computer {
    private String processor;
    private String memory;
    private String hardDisk;

    public Computer(String processor, String memory, String hardDisk) {
        this.processor = processor;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                '}';
    }
}
