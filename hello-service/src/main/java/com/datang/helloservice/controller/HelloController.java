package com.datang.helloservice.controller;

import com.datang.helloservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello world";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String index1(@RequestParam String name) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello1, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User index2(@RequestHeader String name, @RequestHeader Integer age) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello2, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String index3(@RequestBody User user) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello3, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello " + user.getName() + ", " + user.getAge();
    }
}
