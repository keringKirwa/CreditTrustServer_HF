package com.example.hustler_fund_server.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CreateTopics {
    private static final String TopicTwo = "messages_topic";
    private static final String PROGRESS_TOPIC = "progress_topic";
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic messageTopic() {
        return new NewTopic(TopicTwo, 3, (short) 1);
    }

    @Bean
    public NewTopic progressTopic() {
        return new NewTopic(PROGRESS_TOPIC, 3, (short) 1);
    }
}

