package com.controller.bootweb.demo.gof23.command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 命令调用者类
@Component
public class RemoteControl {

    private Command command;

    public void pressButton() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

