package com.controller.bootweb.demo.gof23.abstractfactory;

import org.springframework.stereotype.Service;

// 具体产品A - 邮件服务
@Service("emailService")
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}
