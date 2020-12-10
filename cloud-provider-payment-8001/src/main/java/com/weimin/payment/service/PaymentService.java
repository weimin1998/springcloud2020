package com.weimin.payment.service;


import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;

public interface PaymentService {

    ResultMessage<Integer> createPayment(Payment payment);

    ResultMessage<Payment> queryPayment(Long id);
}
