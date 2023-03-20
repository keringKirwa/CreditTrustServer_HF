package com.group3.kafka.hustlerFunServer.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private static final String TopicTwo = "messages_topic";

    @KafkaListener(topics = TopicTwo ,groupId = "group_id_two")
    public void consumeMessage(String message){

        System.out.println(message);
    }
}
