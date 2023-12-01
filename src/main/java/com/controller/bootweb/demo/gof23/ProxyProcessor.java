package com.controller.bootweb.demo.gof23;


import com.controller.bootweb.demo.gof23.proxy.ProductService;
import com.controller.bootweb.demo.gof23.proxy.ProductServiceImpl;
import com.controller.bootweb.demo.gof23.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProxyProcessor {


    @Autowired
    private ProductServiceProxy productServiceProxy;

    @Autowired
    private ProductService productService;

    //@Bean
    public CommandLineRunner run() {
        return args -> {
            // 使用代理对象
            productServiceProxy.createProxy(productService).addProduct("Laptop");
        };
    }
}
