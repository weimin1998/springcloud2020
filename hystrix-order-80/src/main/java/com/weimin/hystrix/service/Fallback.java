package com.weimin.hystrix.service;

import org.springframework.stereotype.Component;

@Component
public class Fallback implements OrderService{
    // 生产者挂了，就会调这里
    @Override
    public String normal() {
        return "timeout";
    }

    @Override
    public String innormal() {
        return "timeout";
    }
}
