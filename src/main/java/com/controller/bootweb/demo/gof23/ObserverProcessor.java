package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.chain.Handler;
import com.controller.bootweb.demo.gof23.chain.Request;
import com.controller.bootweb.demo.gof23.chain.RequestType;
import com.controller.bootweb.demo.gof23.observer.CustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ObserverProcessor {



    @Autowired
    private CustomEventPublisher eventPublisher;

    //@Bean
    public CommandLineRunner run() {
        return args -> {

            eventPublisher.publishCustomEvent("Hello, observers!");

        };
    }
}
