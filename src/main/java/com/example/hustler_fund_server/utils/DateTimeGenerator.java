package com.example.hustler_fund_server.utils;


import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;

public class DateTimeGenerator {
    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        return now.format(formatter);
    }
}

