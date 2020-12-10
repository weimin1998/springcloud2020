package com.weimin.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.weimin.hystrix.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    OrderService orderService;

    @GetMapping("/consumer/hystrix/innormal")
    /*@HystrixCommand(fallbackMethod = "hand",commandProperties = {
            // 设置3s之内 就是正常的
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    public String innormal(){
        return orderService.innormal();
    }

    @GetMapping("/consumer/hystrix/normal")
    public String normal(){
        return orderService.normal();
    }

    public String hand(){
        return "客户端："+Thread.currentThread().getName()+":hystrix fallback";
    }
}
