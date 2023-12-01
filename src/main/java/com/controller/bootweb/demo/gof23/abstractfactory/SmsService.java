package com.controller.bootweb.demo.gof23.abstractfactory;

import org.springframework.stereotype.Service;

// 具体产品B - 短信服务
@Service("smsService")
public class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}