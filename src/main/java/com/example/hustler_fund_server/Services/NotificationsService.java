package com.example.hustler_fund_server.Services;

import com.example.hustler_fund_server.Entities.Notification;
import com.example.hustler_fund_server.Entities.NotificationsToDelete;
import com.example.hustler_fund_server.Repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationsService {
    @Autowired
    NotificationsRepository notificationsRepository;

    public void save(Notification notification) {
        notificationsRepository.save(notification);
    }

   

    public String deleteNotifications(NotificationsToDelete notificationsToDelete) {
        List<String> toDeleteIds= notificationsToDelete.getNotificationsIDs();
        for (String id:toDeleteIds) {
            notificationsRepository.deleteById(id);

        }
        return "success";
    }

    public List<Notification> getNotifications(String farmerId) {
        return notificationsRepository.findAllByFarmerId(farmerId);
    }
}
