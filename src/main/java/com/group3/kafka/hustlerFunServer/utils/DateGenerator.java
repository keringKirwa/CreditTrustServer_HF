package com.group3.kafka.hustlerFunServer.utils;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateGenerator {
        @Bean
        public String generateDate() {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }
}

