package com.group3.kafka.hustlerFunServer.Producers;

import com.group3.kafka.hustlerFunServer.Entities.Progress;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProgressProducer {
    private static final String PROGRESS_TOPIC = "progress_topic";
    @Autowired
    private KafkaTemplate<String, Progress> progressKafkaTemplate;

    @Bean
    public NewTopic createProgressTopic() {
        return new NewTopic(PROGRESS_TOPIC, 3, (short) 1);
    }


    public String publishProgressEvent(Progress progress) {
        progressKafkaTemplate.send(PROGRESS_TOPIC, progress);
        return "Progress Published Successfully";
    }
}

