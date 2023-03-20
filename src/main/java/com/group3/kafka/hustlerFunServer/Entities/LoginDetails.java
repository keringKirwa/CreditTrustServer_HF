package com.group3.kafka.hustlerFunServer.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("messagesCollection")
public class  LoginDetails {
    @Id
    private String id;
    private String email;
    private String password;


}


