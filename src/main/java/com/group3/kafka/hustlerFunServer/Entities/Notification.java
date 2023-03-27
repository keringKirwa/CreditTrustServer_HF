package com.group3.kafka.hustlerFunServer.Entities;

import com.group3.kafka.hustlerFunServer.utils.DateTimeGenerator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("notificationsCollection")
public class  Notification {
    @Id
    private String id;
    private int read;
    private String farmerId;
    private String message;
    private String dateAndTime= new DateTimeGenerator().getCurrentDateTime();

}


