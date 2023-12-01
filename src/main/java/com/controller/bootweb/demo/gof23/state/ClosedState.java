package com.controller.bootweb.demo.gof23.state;
// 具体状态类 - ClosedState
import org.springframework.stereotype.Component;

@Component("closedState")
public class ClosedState implements State {

    @Override
    public void handle() {
        System.out.println("Door is closed");
    }
}

