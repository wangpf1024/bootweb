package com.controller.bootweb.demo.gof23.state;

// 具体状态类 - OpenState
import org.springframework.stereotype.Component;

@Component("openState")
public class OpenState implements State {

    @Override
    public void handle() {
        System.out.println("Door is open");
    }
}
