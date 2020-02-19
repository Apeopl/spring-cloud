package com.datang.ribbonconsumer.controller;

import com.datang.ribbonconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return consumerService.helloService();
    }
}
