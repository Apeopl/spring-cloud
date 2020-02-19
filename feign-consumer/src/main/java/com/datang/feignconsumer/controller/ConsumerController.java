package com.datang.feignconsumer.controller;

import com.datang.feignconsumer.entity.User;
import com.datang.feignconsumer.service.HelloService;
import com.datang.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder builder = new StringBuilder();
        builder.append(helloService.hello()).append("\n")
                .append(helloService.hello("zheng")).append("\n")
                .append(helloService.hello("fu", 26).toString()).append("\n")
                .append(helloService.hello(new User("zhang", 33))).append("\n");
        return builder.toString();
    }

    @RequestMapping(value = "/feign-consumers", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("t-mac")).append("\n")
                .append(refactorHelloService.hello(new com.datang.helloserviceapi.entity.User("kobe", 41)))
                .append("\n")
                .append(refactorHelloService.hello("james", 36)).append("\n");
        return sb.toString();
    }
}
