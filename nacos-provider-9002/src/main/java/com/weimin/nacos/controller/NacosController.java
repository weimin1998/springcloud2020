package com.weimin.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    String port;
    @GetMapping("/nacos/provider")
    public String nacos(){
        return "nacos :"+port;
    }
}
