package com.weimin.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//动态刷新
public class ConfigController {

    @Value("${config.info}")
    String info;

    @GetMapping("/getInfo")
    public String getInfo(){
        return info;
    }
}
