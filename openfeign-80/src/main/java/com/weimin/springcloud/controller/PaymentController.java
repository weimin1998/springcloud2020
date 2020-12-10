package com.weimin.springcloud.controller;

import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import com.weimin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/consumer/openFeign/payment/query/{id}")
    public ResultMessage<Payment> queryPayment(@PathVariable("id") Long id){
        System.out.println("消费者服务使用openFeign调用 支付服务 查询订单");
        return paymentService.queryPayment(id);
    }

    @GetMapping("/openFeignTimeout")
    public String timeout(){
        return paymentService.timeout();
    }
}
