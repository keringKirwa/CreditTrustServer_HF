package com.group3.kafka.hustlerFunServer.Controllers;

import com.group3.kafka.hustlerFunServer.Entities.Notification;
import com.group3.kafka.hustlerFunServer.Entities.NotificationsToDelete;
import com.group3.kafka.hustlerFunServer.Services.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationsController {

    @Autowired
    NotificationsService notificationsService;

    @GetMapping("/getNotifications/{farmerId}")
    public List<Notification> getNotifications(@PathVariable String farmerId)  {
        return notificationsService.getNotifications(farmerId);
    }


    @PostMapping("/deleteNotifications")
    public String deleteNotifications(@RequestBody NotificationsToDelete notificationsToDelete)  {
         notificationsService.deleteNotifications(notificationsToDelete);
        return "success";
    }
}
