package com.controller.bootweb.demo.gof23.proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.stereotype.Component;

// 代理类
@Component
public class ProductServiceProxy implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before method call: " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("After method call: " + methodInvocation.getMethod().getName());
        return result;
    }

    // 创建代理对象的方法
    public ProductService createProxy(ProductService target) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(target);
        proxyFactoryBean.addAdvice(this);
        return (ProductService) proxyFactoryBean.getObject();
    }
}

