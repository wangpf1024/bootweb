package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.adapter.Adapter;
import com.controller.bootweb.demo.gof23.singleton.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AdapterProcessor {

    @Autowired
    ApplicationContext context;
    //@Bean
    public CommandLineRunner run(@Qualifier("adapterImpl")Adapter adapter) {
        return args -> {
            // 使用适配器调用目标接口的方法
            adapter.specificRequest();
        };
    }

}
