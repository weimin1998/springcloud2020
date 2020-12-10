package com.weimin.zk.controller;


import com.weimin.springcloud.common.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    private static String PAYMENT_URL="http://cloud-provider-payment";


    @GetMapping("/consumer/zk")
    public ResultMessage<String> zkPayment(){
        System.out.println("zk 消费服务调用 提供者");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",ResultMessage.class);
    }
}
