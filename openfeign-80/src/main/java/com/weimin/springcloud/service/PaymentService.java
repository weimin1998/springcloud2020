package com.weimin.springcloud.service;


import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {

    @GetMapping("/payment/queryPayment/{id}")
    ResultMessage<Payment> queryPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String timeout();

}
/*注解接口*/

/*feign 自带负载均衡*/