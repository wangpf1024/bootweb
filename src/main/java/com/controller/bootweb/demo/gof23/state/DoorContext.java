package com.controller.bootweb.demo.gof23.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 上下文类
@Component
public class DoorContext {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void performAction() {
        state.handle();
    }
}
