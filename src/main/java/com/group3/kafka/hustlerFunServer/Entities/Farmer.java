package com.group3.kafka.hustlerFunServer.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.group3.kafka.hustlerFunServer.utils.RandomAccountNumberGenerator;

@Data
@Document("registeredFarmers")
public class Farmer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String nationalID;
    private String accountNumber = new RandomAccountNumberGenerator().generateAccountNumber();
    private String password;
    private String farmSize;
    private String county;
    private String constituency;
    private double latitude;
    private double longitude;
    private boolean hasActiveLoan = false;
    private String activeLoanId;
    private int numberOfProjects = 0;

}
