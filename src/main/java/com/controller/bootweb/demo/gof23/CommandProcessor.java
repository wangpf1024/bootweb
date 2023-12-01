package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.command.LightOffCommand;
import com.controller.bootweb.demo.gof23.command.LightOnCommand;
import com.controller.bootweb.demo.gof23.command.RemoteControl;
import com.controller.bootweb.demo.gof23.strategy.CreditCardPaymentStrategy;
import com.controller.bootweb.demo.gof23.strategy.PayPalPaymentStrategy;
import com.controller.bootweb.demo.gof23.strategy.PaymentContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CommandProcessor {

    @Autowired
    private RemoteControl remoteControl;

    @Autowired
    @Qualifier("lightOnCommand")
    private LightOnCommand lightOnCommand;

    @Autowired
    @Qualifier("lightOffCommand")
    private LightOffCommand lightOffCommand;

    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 按下按钮开灯
            remoteControl.setCommand(lightOnCommand);
            remoteControl.pressButton();

            // 按下按钮关灯
            remoteControl.setCommand(lightOffCommand);
            remoteControl.pressButton();
        };
    }
}
