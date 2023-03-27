package com.group3.kafka.hustlerFunServer.Entities;

import lombok.Data;

import java.util.List;
@Data
public class NotificationsToDelete {
    private List<String> notificationsIDs;
}
