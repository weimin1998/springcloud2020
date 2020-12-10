package com.weimin.payment.controller;

import com.weimin.springcloud.common.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;
    @GetMapping("/payment/zk")
    public ResultMessage zk(){
        return new ResultMessage(200,"zk:"+port+","+ UUID.randomUUID(),1);
    }
}
