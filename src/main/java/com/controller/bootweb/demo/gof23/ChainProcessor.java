package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.chain.ConcreteHandlerB;
import com.controller.bootweb.demo.gof23.chain.Handler;
import com.controller.bootweb.demo.gof23.chain.Request;
import com.controller.bootweb.demo.gof23.chain.RequestType;
import com.controller.bootweb.demo.gof23.template.AbstractOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ChainProcessor {



    @Autowired
    private Handler firstHandler;

    @Autowired
    private Handler secondHandler;

    //@Bean
    public CommandLineRunner run() {
        return args -> {

            firstHandler.setSuccessor(secondHandler);

            // 创建请求
            Request requestA = new Request(RequestType.TYPE_A);
            Request requestB = new Request(RequestType.TYPE_B);

            // 处理请求
            firstHandler.handleRequest(requestA);
            System.out.println();

            firstHandler.handleRequest(requestB);

        };
    }
}
