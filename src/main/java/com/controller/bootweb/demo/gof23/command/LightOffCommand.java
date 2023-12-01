package com.controller.bootweb.demo.gof23.command;
// 具体命令类 - LightOffCommand
import org.springframework.stereotype.Component;

@Component("lightOffCommand")
public class LightOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Light is OFF");
    }
}

