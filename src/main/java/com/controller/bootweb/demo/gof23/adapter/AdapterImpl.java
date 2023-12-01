package com.controller.bootweb.demo.gof23.adapter;

import org.springframework.stereotype.Service;

// 适配器类
@Service("adapterImpl")
public class AdapterImpl implements Adapter {
    private Target target;

    public AdapterImpl(Target target) {
        this.target = target;
    }

    @Override
    public void specificRequest() {
        target.request();
    }
}
