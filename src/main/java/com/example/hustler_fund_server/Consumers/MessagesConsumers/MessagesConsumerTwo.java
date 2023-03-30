package com.example.hustler_fund_server.Consumers.MessagesConsumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class MessagesConsumerTwo {
    private static final String TopicTwo = "messages_topic";

    @KafkaListener(topics = TopicTwo ,groupId = "group_id_two")
    public void consumeMessage(String message){

        System.out.println("Consumer two : " +message);
    }
}