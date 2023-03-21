package com.group3.kafka.hustlerFunServer.Consumers.ProgressConsumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group3.kafka.hustlerFunServer.Entities.Progress;
import com.group3.kafka.hustlerFunServer.Services.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProgressConsumerOne  {
    @Autowired
    ProgressService progressService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC_TWO = "progress_topic";

    @KafkaListener(topics = TOPIC_TWO ,groupId = "progress_group_id")
    public void consumeMessage(String progressString) throws JsonProcessingException {
        Progress progressEvent = objectMapper.readValue(progressString, Progress.class);
        progressService.save(progressEvent);
        System.out.println("++++++>>> CONSUMER ONE SAVED THE MESSAGE SUCCESSFULLY");
    }
}
