package com.controller.bootweb.demo.gof23.proxy;

import org.springframework.stereotype.Service;

// 实现类
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(String productName) {
        System.out.println("Product added: " + productName);
    }
}
