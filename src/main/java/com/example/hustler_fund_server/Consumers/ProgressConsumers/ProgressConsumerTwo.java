package com.example.hustler_fund_server.Consumers.ProgressConsumers;

import com.example.hustler_fund_server.Entities.Progress;
import com.example.hustler_fund_server.Services.ProgressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProgressConsumerTwo  {

    @Autowired
    ProgressService progressService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC_TWO = "progress_topic";

    @KafkaListener(topics = TOPIC_TWO ,groupId = "progress_group_id")
    public void consumeProgressEvents(String progressString) throws JsonProcessingException {
        Progress progressEvent = objectMapper.readValue(progressString, Progress.class);
        progressService.save(progressEvent);
        System.out.println("++++++>>> CONSUMER TWO SAVED THE MESSAGE SUCCESSFULLY");

    }
}
