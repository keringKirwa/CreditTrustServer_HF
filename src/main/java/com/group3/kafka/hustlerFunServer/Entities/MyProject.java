package com.group3.kafka.hustlerFunServer.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("myProjectsCollection")
public class MyProject {
    @Id
    private String id;
    private String projectName;
    private String cropName;
    private String farmerId;
}


