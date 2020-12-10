package com.weimin.payment.service.impl;


import com.weimin.payment.mapper.PaymentMapper;

import com.weimin.payment.service.PaymentService;
import com.weimin.springcloud.common.ResultMessage;
import com.weimin.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public ResultMessage<Integer> createPayment(Payment payment) {
        int insert = paymentMapper.insert(payment);

        if(insert==1){
            return new ResultMessage<>(200,"订单创建成功,serverPort:"+serverPort,insert);
        }else {
            return new ResultMessage<>(500,"订单创建失败,serverPort:"+serverPort,insert);
        }

    }

    @Override
    public ResultMessage<Payment> queryPayment(Long id) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        if(payment!=null){
            return new ResultMessage<>(200,"查询订单成功,serverPort:"+serverPort,payment);
        }else {
            return new ResultMessage<>(200,"没有该订单,serverPort:"+serverPort,payment);
        }

    }
}
