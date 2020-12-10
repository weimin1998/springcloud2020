package com.weimin.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${config.info}")
    public String info;


    @RequestMapping("/info")
    public String info(){
        return info;
    }
}
//cmd中：
// curl -X POST "http://localhost:3355/actuator/refresh"