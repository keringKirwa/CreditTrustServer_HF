package com.group3.kafka.hustlerFunServer.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("registeredFarmers")
public class  Farmer {
    @Id
    private String id;
    private String farmerName;
    private String phoneNumber;
    private String nationalID;
    private String emailAddress;
    private String password;
    private String farmSize;
    private String county;
    private String constituency;
    private String latitudeAndLongitude;
    private boolean hasActiveLoan =false;
    private String activeLoanId;

}

