package com.example.hustler_fund_server.Producers;

import com.example.hustler_fund_server.Entities.Progress;
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




    public String publishProgressEvent(Progress progress) {
        progressKafkaTemplate.send(PROGRESS_TOPIC, progress);
        return "Progress Published Successfully";
    }
}

