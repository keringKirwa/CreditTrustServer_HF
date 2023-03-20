package com.group3.kafka.hustlerFunServer.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("registeredFarmers")
public class Message {
    @Id
    private String id;
    private String userId;
    private String stringMessage;


}
