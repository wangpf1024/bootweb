package com.controller.bootweb.demo.gof23.chain;
// 具体处理者类 - ConcreteHandlerB
import org.springframework.stereotype.Component;
// 具体处理者类 - ConcreteHandlerB
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("secondHandler")
public class ConcreteHandlerB implements Handler {
    private Handler successor;

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals(RequestType.TYPE_B)) {
            System.out.println("ConcreteHandlerB handles the request");
        } else {
            System.out.println("Passing request to the next handler");
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

