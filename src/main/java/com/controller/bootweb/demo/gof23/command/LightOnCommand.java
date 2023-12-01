package com.controller.bootweb.demo.gof23.command;
// 具体命令类 - LightOnCommand
import org.springframework.stereotype.Component;

@Component("lightOnCommand")
public class LightOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Light is ON");
    }
}

