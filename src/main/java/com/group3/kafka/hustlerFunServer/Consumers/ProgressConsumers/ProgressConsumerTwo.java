package com.group3.kafka.hustlerFunServer.Consumers.ProgressConsumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group3.kafka.hustlerFunServer.Entities.Progress;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProgressConsumerTwo  {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC_TWO = "progress_topic";

    @KafkaListener(topics = TOPIC_TWO ,groupId = "progress_group_id")
    public void consumeProgressEvents(String progressString) throws JsonProcessingException {
        Progress progressEvent = objectMapper.readValue(progressString, Progress.class);

        System.out.println("Progress Consumer Two +++++>>>  : Created On: " + progressEvent.getCreatedOn() + "Progress Activity Name " + progressEvent.getActivityName()+ "progress id " +progressEvent.getId());
    }
}
