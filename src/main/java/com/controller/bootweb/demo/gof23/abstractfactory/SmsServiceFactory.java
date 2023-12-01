package com.controller.bootweb.demo.gof23.abstractfactory;


import org.springframework.stereotype.Service;

// 具体工厂B - 短信服务工厂
@Service("smsServiceFactory")
public class SmsServiceFactory implements MessageServiceFactory {

    @Override
    public MessageService createMessageService() {
        return new SmsService();
    }
}