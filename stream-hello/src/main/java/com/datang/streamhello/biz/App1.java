package com.datang.streamhello.biz;

import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;

@EnableRxJavaProcessor
public class App1 {

    @Bean
    public RxJavaProcessor<String, String> processor() {
        return inputStream -> inputStream.map(data -> {
            System.out.println("rx received: " + data);
            return data;
        }).map(data -> String.valueOf("from input channel return - " + data));
    }
}
