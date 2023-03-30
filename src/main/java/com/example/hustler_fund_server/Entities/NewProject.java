package com.example.hustler_fund_server.Entities;

import com.example.hustler_fund_server.utils.DateGenerator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("projectsCollection")
public class NewProject {

    @Id
    private String id;
    private String projectName;
    private String latestProgressId;
    private String crop;
    private String farmerId;
    private String loanId;
    private int numberOfMonths;
    private String cropImage;
    private  String createdOn =new DateGenerator().generateDate();
}


