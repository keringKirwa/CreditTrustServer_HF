package com.example.hustler_fund_server.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    private static final int PARTITIONS = 3;
    private static final short REPLICATION_FACTOR = 1;
    private static final String MESSAGE_TOPIC = "messages_topic";
    private static final String PROGRESS_TOPIC = "progress_topic";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:29092");
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic messagesTopic() {
        return TopicBuilder.name(MESSAGE_TOPIC)
                .partitions(PARTITIONS)
                .replicas(REPLICATION_FACTOR)
                .compact()
                .build();
    }

    @Bean
    public NewTopic progressTopic() {
        return TopicBuilder.name(PROGRESS_TOPIC)
                .partitions(PARTITIONS)
                .replicas(REPLICATION_FACTOR)
                .compact()
                .build();
    }

}

