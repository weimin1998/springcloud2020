package com.weimin.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {

    @Value("${service-url.nacos-provider-url}")
    String url;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/nacos/consumer")
    public String nacos(){
        return restTemplate.getForObject(url+"/nacos/provider",String.class);
    }
}
