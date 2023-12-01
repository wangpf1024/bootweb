package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.proxy.ProductService;
import com.controller.bootweb.demo.gof23.proxy.ProductServiceProxy;
import com.controller.bootweb.demo.gof23.template.AbstractOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TemplateProcessor {


    @Autowired
    private AbstractOrderProcessor inStoreOrderProcessor;

    @Autowired
    private AbstractOrderProcessor onlineOrderProcessor;

    //@Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("Processing online order:");
            onlineOrderProcessor.processOrder();

            System.out.println();

            // 处理实体店订单
            System.out.println("Processing in-store order:");
            inStoreOrderProcessor.processOrder();

        };
    }
}
