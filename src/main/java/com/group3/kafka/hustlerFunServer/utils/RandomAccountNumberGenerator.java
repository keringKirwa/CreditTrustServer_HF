package com.group3.kafka.hustlerFunServer.utils;

import java.util.Random;

public class RandomAccountNumberGenerator {

    public String generateAccountNumber() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }

        // Add a random uppercase or lowercase letter to the account number
        sb.insert(rand.nextInt(8), characters.charAt(rand.nextInt(26)));
        return sb.toString();
    }

}
