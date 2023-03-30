package com.example.hustler_fund_server.Entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("loansCollection")
public class  Loan {
    @Id
    private String id;
    private String farmerId;
    private String projectId;
    private int amountBorrowed;
    private int amountDisbursed = 0 ;
    private byte disbursementStatus = 0 ;
    private byte approvalStatus = 0 ;
    private String nextBatchOn;


}

