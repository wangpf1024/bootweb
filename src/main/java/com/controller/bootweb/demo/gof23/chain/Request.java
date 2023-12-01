package com.controller.bootweb.demo.gof23.chain;
// 请求类
public class Request {
    private RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}
