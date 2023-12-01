package com.controller.bootweb.demo.gof23.singleton;

import org.springframework.stereotype.Service;

// 单例类
@Service
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // 私有构造方法，防止外部直接实例化
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
}

