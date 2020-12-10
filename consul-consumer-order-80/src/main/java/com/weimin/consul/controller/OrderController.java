package com.weimin.consul.controller;


import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    private static String PAYMENT_URL="http://consul-provider-payment";


    @GetMapping("/consumer/consul")
    public ResultMessage<String> consulPayment(){
        System.out.println("consul 消费服务调用 提供者");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",ResultMessage.class);
    }
}
