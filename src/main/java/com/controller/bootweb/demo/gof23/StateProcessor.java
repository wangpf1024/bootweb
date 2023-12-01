package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.command.LightOffCommand;
import com.controller.bootweb.demo.gof23.command.LightOnCommand;
import com.controller.bootweb.demo.gof23.command.RemoteControl;
import com.controller.bootweb.demo.gof23.state.ClosedState;
import com.controller.bootweb.demo.gof23.state.DoorContext;
import com.controller.bootweb.demo.gof23.state.OpenState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StateProcessor {

    @Autowired
    private DoorContext doorContext;

    @Autowired
    @Qualifier("openState")
    private OpenState openState;

    @Autowired
    @Qualifier("closedState")
    private ClosedState closedState;
    @Bean
    public CommandLineRunner run() {
        return args -> {
            // 初始状态为关闭
            doorContext.setState(closedState);
            doorContext.performAction();

            // 切换状态为打开
            doorContext.setState(openState);
            doorContext.performAction();
        };
    }
}
