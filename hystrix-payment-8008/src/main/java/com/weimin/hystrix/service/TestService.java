package com.weimin.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;



import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TestService {

    public String test1(){
        return Thread.currentThread().getName()+":正常访问";
    }


    @HystrixCommand(fallbackMethod = "hand",commandProperties = {
            // 设置3s之内 就是正常的
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String test2(){
        /*try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //int a = 10/0;
        System.out.println(Thread.currentThread().getName()+":request timeout");
        return Thread.currentThread().getName()+":超时访问";
    }

    public String hand(){
        return "服务端："+Thread.currentThread().getName()+":hystrix fallback";
    }


    // 熔断


    // 指定时间内，
    @HystrixCommand(fallbackMethod = "hand2",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String test3(Long id){

        if(id<0){
            throw new RuntimeException("id<0,熔断");
        }
        return IdUtil.simpleUUID();
    }


    public String hand2(Long l){
        return Thread.currentThread().getName()+":hystrix break"+l;
    }
}
