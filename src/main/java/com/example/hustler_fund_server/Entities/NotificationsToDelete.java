package com.example.hustler_fund_server.Entities;

import lombok.Data;

import java.util.List;
@Data
public class NotificationsToDelete {
    private List<String> notificationsIDs;
}
