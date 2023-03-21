package com.group3.kafka.hustlerFunServer.Consumers.MessagesConsumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group3.kafka.hustlerFunServer.Entities.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class MessagesConsumerOne {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TopicTwo = "messages_topic";

    @KafkaListener(topics = TopicTwo ,groupId = "group_id_two")
    public void consumeMessage(String messageString) throws JsonProcessingException {
        Message messageObject = objectMapper.readValue(messageString, Message.class);
        System.out.println("Consumer One +++++>>>  : " +messageObject.getStringMessage());
    }
}
