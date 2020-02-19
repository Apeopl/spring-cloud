package com.datang.ribbonconsumer.service;

import com.datang.helloserviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {
}
