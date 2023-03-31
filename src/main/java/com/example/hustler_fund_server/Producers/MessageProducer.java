package com.example.hustler_fund_server.Producers;

import com.example.hustler_fund_server.Entities.Message;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 When the sendMessage method is called, if the messages-topic doesn't exist yet,
 * Kafka will create it automatically with the configuration properties specified in the NewTopic bean.
 */

@Service
public class MessageProducer {
    private static final String TopicTwo = "messages_topic";

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    public  String  sendMessage(Message message){
        kafkaTemplate.send(TopicTwo, message);
        return "Published Successfully";
    }

}

