package com.lagou.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(CustomChannel.class)
public class LogMessageConsumerService {

    @StreamListener(CustomChannel.INPUT_LOG)
    public void recevieLogMessages(Message<String> message) {
        System.out.println("=========LOG接收到的消息：" + message);
    }

}
