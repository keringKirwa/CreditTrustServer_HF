package com.group3.kafka.hustlerFunServer.Producers;

import com.group3.kafka.hustlerFunServer.Entities.Message;
import com.group3.kafka.hustlerFunServer.config.KafkaConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FirstProducer {
    private static final String TopicONE = "test_topic";

    @Autowired
    private KafkaConfig kafkaConfig;

    public void sendMessage(Message message){

        this.kafkaConfig.messageKafkaTemplate().send(TopicONE,message);
    }

    @Bean
    public NewTopic createTopicOne(){

        return new NewTopic(TopicONE,3,(short) 1);
    }




}
