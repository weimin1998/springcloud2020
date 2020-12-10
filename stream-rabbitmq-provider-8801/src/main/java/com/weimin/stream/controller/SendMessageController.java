package com.weimin.stream.controller;

import com.weimin.stream.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    SendMessageService sendMessageService;

    @GetMapping("/sendMessage")
    public String send(){
        return sendMessageService.send();
    }
}
