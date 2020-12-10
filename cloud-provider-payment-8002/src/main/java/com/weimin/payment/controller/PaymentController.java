package com.weimin.payment.controller;


import com.weimin.payment.service.PaymentService;
import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "create")
    public ResultMessage<Integer> create(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    @GetMapping("queryPayment/{id}")
    public ResultMessage<Payment> queryPayment(@PathVariable("id") Long id){
        return paymentService.queryPayment(id);
    }

    @GetMapping("timeout")
    public String timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {


        }
        return "feign timeout";
    }
}
