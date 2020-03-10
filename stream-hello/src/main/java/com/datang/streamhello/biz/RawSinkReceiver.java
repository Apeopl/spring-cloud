package com.datang.streamhello.biz;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(value = {Sink.class})
public class RawSinkReceiver {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object load) {
        System.out.println("raw received: " + load);
    }
}
