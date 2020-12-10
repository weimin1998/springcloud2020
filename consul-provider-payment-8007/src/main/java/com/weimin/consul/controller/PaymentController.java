package com.weimin.consul.controller;

import com.weimin.springcloud.common.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;
    @GetMapping("/payment/consul")
    public ResultMessage consul(){
        return new ResultMessage(200,"consul:"+port+","+ UUID.randomUUID(),1);
    }
}
