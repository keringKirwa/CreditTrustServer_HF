package com.group3.kafka.hustlerFunServer.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FirstConsumer {
    private static final String TopicONE = "test_topic";
    @KafkaListener(topics = TopicONE, groupId = "group_id")
    public void consumeMessage(String message){

        System.out.println(message);
    }
}
