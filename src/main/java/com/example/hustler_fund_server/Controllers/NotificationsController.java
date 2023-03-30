package com.example.hustler_fund_server.Controllers;

import com.example.hustler_fund_server.Entities.NotificationsToDelete;
import com.example.hustler_fund_server.Services.NotificationsService;
import com.example.hustler_fund_server.Entities.Notification;
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
