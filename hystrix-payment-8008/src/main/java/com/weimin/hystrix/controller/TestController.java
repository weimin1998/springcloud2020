package com.weimin.hystrix.controller;


import com.weimin.hystrix.service.TestService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Value("${server.port}")
    String serverPort;

    @Autowired
    TestService testService;

    @GetMapping("/hystrix/normal")
    public String normal(){
        return testService.test1();
    }

    @GetMapping("/hystrix/innormal")
    public String innormal(){
        return testService.test2();
    }


    @GetMapping("/hystrix/innormal/{id}")
    public String breakk(@PathVariable("id") Long id){
        return testService.test3(id);
    }
}
