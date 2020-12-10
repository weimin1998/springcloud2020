package com.weimin.stream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)
public class SendMessageServiceImpl implements SendMessageService{

    @Resource
    MessageChannel output;

    @Override
    public String send() {

        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        return s;
    }
}
