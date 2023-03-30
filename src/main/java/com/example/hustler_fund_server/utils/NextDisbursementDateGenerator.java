package com.example.hustler_fund_server.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class NextDisbursementDateGenerator {

    public String getNextLoanBatchDate(double monthsUntilNextBatch) {
        int daysUntilNextBatch = (int) (monthsUntilNextBatch * 15);
        LocalDate currentDate = LocalDate.now();
        LocalDate nextBatchDate = currentDate.plusDays(daysUntilNextBatch);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM,d,yyyy");
        return nextBatchDate.format(formatter);
    }
}

