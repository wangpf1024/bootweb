package com.controller.bootweb.demo.gof23;

import com.controller.bootweb.demo.gof23.abstractfactory.MessageService;
import com.controller.bootweb.demo.gof23.abstractfactory.MessageServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessor {

    private final MessageServiceFactory messageServiceFactory;

    @Autowired
    public MessageProcessor(@Qualifier("emailServiceFactory") MessageServiceFactory messageServiceFactory) {
        this.messageServiceFactory = messageServiceFactory;
    }

    public void processMessage(String message) {
        MessageService messageService = messageServiceFactory.createMessageService();
        messageService.sendMessage(message);
    }
}