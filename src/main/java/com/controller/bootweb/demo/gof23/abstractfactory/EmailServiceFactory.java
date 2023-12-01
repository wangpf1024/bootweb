package com.controller.bootweb.demo.gof23.abstractfactory;

import org.springframework.stereotype.Service;

// 具体工厂A - 邮件服务工厂
@Service("emailServiceFactory")
public class EmailServiceFactory implements MessageServiceFactory {

    @Override
    public MessageService createMessageService() {
        return new EmailService();
    }
}