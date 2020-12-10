package com.weimin.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "HYSTRIX-PAYMENT-8008",fallback = Fallback.class)
public interface OrderService {
    @GetMapping("/hystrix/normal")
    String normal();

    @GetMapping("/hystrix/innormal")
    String innormal();
}
