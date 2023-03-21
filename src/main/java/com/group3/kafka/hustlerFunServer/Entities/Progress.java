package com.group3.kafka.hustlerFunServer.Entities;

import com.group3.kafka.hustlerFunServer.utils.DateGenerator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("progressCollection")
public class  Progress {

    @Id
    private String id;
    private String projectId;
    private int amountSpent;
    private String activityName;
    private String createdOn =new DateGenerator().generateDate();
    private String progressImage;


}

