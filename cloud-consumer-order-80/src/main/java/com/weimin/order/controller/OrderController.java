package com.weimin.order.controller;


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

    // 单实例 就直接访问具体的ip+端口号
    //private static String PAYMENT_URL="http://localhost:8001/payment/";

    // 集群，就要访问微服务名了,不需要访问具体的ip,然后开启负载均衡
    private static String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";



    @GetMapping(value = "/consumer/payment/create")
    public ResultMessage<Payment> create(Payment payment){
        System.out.println("消费者服务调用 支付服务 创建订单");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,ResultMessage.class);
    }


    @GetMapping("/consumer/payment/query/{id}")
    public ResultMessage<Payment> queryPayment(@PathVariable("id") Long id){
        System.out.println("消费者服务调用 支付服务 查询订单");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/queryPayment/"+id,ResultMessage.class);
    }
}
