package com.weimin.order;

import com.weimin.rule.RuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
// 替换负载均衡规则
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = RuleConfiguration.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

    @Bean
    // 使得RestTemplate负载均衡，访问服务提供者
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
