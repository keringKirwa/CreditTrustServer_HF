package com.group3.kafka.hustlerFunServer.Consumers.MessagesConsumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class ConsumerTwo {
    private static final String TopicTwo = "messages_topic";

    @KafkaListener(topics = TopicTwo ,groupId = "group_id_two")
    public void consumeMessage(String message){

        System.out.println("Consumer two : " +message);
    }
}