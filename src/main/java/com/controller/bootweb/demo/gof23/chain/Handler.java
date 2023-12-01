package com.controller.bootweb.demo.gof23.chain;

// 处理者接口
public interface Handler {
    void handleRequest(Request request);
    void setSuccessor(Handler successor);
}
