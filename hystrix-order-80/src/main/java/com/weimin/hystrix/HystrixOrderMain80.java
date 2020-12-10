package com.weimin.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

@EnableHystrix
public class HystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class,args);
    }
}
