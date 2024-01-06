package com.weimin.payment.controller;


import com.weimin.payment.service.PaymentService;
import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "create")
    public ResultMessage<Integer> create(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("queryPayment/{id}")
    public ResultMessage<Payment> queryPayment(@PathVariable("id") Long id) {
        return paymentService.queryPayment(id);
    }


    @GetMapping("timeout")
    public String timeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {


        }
        return "feign timeout";
    }


    // org.springframework.cloud.client.discovery.DiscoveryClient;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "/t" + instance.getHost() + "/t" + instance.getPort() + "/t" + instance.getUri());
        }
        return discoveryClient;
    }
}
